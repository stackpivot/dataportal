//
//	Copyright (c) 2003  San Diego Supercomputer Center (SDSC),
//	University of California, San Diego (UCSD), San Diego, CA, USA.
//
//	Users and possessors of this source code are hereby granted a
//	nonexclusive, royalty-free copyright and design patent license
//	to use this code in individual software.  License is not granted
//	for commercial resale, in whole or in part, without prior written
//	permission from SDSC/UCSD.  This source is provided "AS IS"
//	without express or implied warranty of any kind.
//
//
//  FILE
//	MetaDataRecordList .java	-  edu.sdsc.grid.io.MetaDataRecordList
//
//  CLASS HIERARCHY
//	java.lang.Object
//	    |
//	    +-.MetaDataRecordList
//
//  PRINCIPAL AUTHOR
//	Lucas Gilbert, SDSC/UCSD
//
//
package edu.sdsc.grid.io;

import java.io.IOException;

/**
 * A "meta data record list" is a list of results from a metadata query.
 * Each entry in the list is one record, corresponding to one file found
 * by the query. Information in that record includes field values for
 * that file.
 *<P>
 * Results of long queries will only return a partial list
 * to save on bandwidth which can be iterated through by further calls to
 * the server.
 *<P>
 * Subclasses are expected to be private inner classes within the
 * various file server implementations. Those private inner classes
 * work closely with the file server to do a multi-step query that does
 * not have to return everything immediately. The SRBMetaDataRecordList
 * class, for instance, works with partial query results and, on need,
 * issues a query for the next batch of results. If some of the results
 * are never asked for, they are never retreived. To the caller, some
 * requests for a record are immediate while others pause while the
 * partial query is sent.
 *<P>
 * The subclasses are private, but their constructors are public to
 * the file server class. So, the SRBFileSystem can call the constructor
 * of an SRBMetaDataRecordList class, but neither the class or the
 * constructor are visible to the API user.
 *
 * @author	Lucas Gilbert, San Diego Supercomputer Center
 */
public abstract class MetaDataRecordList extends Object
{
//----------------------------------------------------------------------
//  Constants
//----------------------------------------------------------------------



//----------------------------------------------------------------------
//  Fields
//----------------------------------------------------------------------
	/**
	 * Stores the descriptions and names of the related fields for all the
	 * values returned.
	 */
	protected MetaDataField[] fields;


	/**
	 * The query returned from the server might look like:
	 *<P>
	 * field name:	"data name"	"owner"		"size" <br>
	 * record1:			test1.txt		testuser	300 <br>
	 * record2:			test2.txt		testuser	500 <br>
	 * record3:			image1.jpg	demouser	14000
	 */
	protected Object[] records;



//----------------------------------------------------------------------
//  Constructors and Destructors
//----------------------------------------------------------------------
	/**
	 * No error checking.
	 */
	protected MetaDataRecordList(	MetaDataField[] fields, Object[] recordValues )
	{
		if (fields == null)
			throw new NullPointerException("fields cannot be null");

		int fieldsLength = fields.length;
		if (fieldsLength != recordValues.length) {
			throw new IllegalArgumentException();
		}

		this.fields = fields;
		records = new Object[fieldsLength];
		System.arraycopy(	recordValues, 0, records, 0, recordValues.length);
	}


	/**
	 *
	 */
	public MetaDataRecordList( MetaDataField field, int recordValue )
	{
		fields = new MetaDataField[1];
		fields[0] = field;

		records = new Object[1];
		records[0] = new Integer(recordValue);
	}

	/**
	 *
	 */
	public MetaDataRecordList( MetaDataField field, float recordValue )
	{
		fields = new MetaDataField[1];
		fields[0] = field;

		records = new Object[1];
		records[0] = new Float(recordValue);
	}

	/**
	 *
	 */
	public MetaDataRecordList( MetaDataField field, String recordValue )
	{
		fields = new MetaDataField[1];
		fields[0] = field;

		records = new Object[1];
		records[0] = recordValue;
	}

	/**
	 *
	 */
	public MetaDataRecordList( MetaDataField field, MetaDataTable recordValue )
	{
		fields = new MetaDataField[1];
		fields[0] = field;

		records = new Object[1];
		records[0] = recordValue;
	}



	/**
	 * Finalizes the object by explicitly letting go of each of
	 * its internally held values.
	 */
	protected void finalize( )
	{
		if (records != null)
			records = null;
		if (fields != null)
			fields = null;
	}




//----------------------------------------------------------------------
// Getters
//----------------------------------------------------------------------
	/**
	 * Returns the number of fields for each record in the
   * list. This field count will generally equal the number of fields
   * intially selected by the query.
	 */
  public int getFieldCount( )
  {
  	if (fields != null)
	  	return fields.length;
	  else
	  	return -1;
  }

  /**
   * Get the MetaDataFields for this record list.
   */
  public MetaDataField[] getFields()
  {
 		return fields;
  }


  /**
   * Get the MetaDataField object describing the indicated
   * field.
   */
  public MetaDataField getField( int index )
  {
  	if (fields != null)
  		return fields[index];
	  else
	  	return null;
  }


	/**
	 *  Get the field name for the indicated field. This is
   * a shorthand for:<br>
   *  getField(index).getName()
	 */
  public String getFieldName( int index )
  {
  	if ((fields != null) && (index < fields.length))
	  	return fields[index].getName();
	  else
	  	return null;
//TODO should this be expanded, iOR error?
  }


  /**
   * Get the data type for the field's values. This is
   * a shorthand for:<br>
   *  getField(index).getType()
   */
  public int getFieldType( int index )
  {
  	if (fields != null)
			return fields[index].getType();
	  else
	  	return -1;
  }



  /**
   * Get the index for the named field.
   * @return the index of the field,
   * 		or -1 if this recordlist does not contain that field
   */
  public int getFieldIndex( String fieldName )
  {
  	if ((fields != null) && fieldName != null) {
  		for (int i=0;i<fields.length;i++) {
  			if (fields[i].getName().equals(fieldName)) {
  				return i;
  			}
  		}
  	}

	  return -1;
  }




	/**
	 * Returns the number of records in the list.
	 */
  public int getRecordCount( )
  {
  	if (records != null)
	  	return records.length;
	  else
	  	return -1;
  }


//TODO ?
  /*
   * The request vs. actual type gets these results:
	 *<P>
   * Request Actual Does this<br>
   * ------- ------ ---------<br>
   * int int returns int<br>
   * int float casts to int & returns<br>
   * int string parses as int & returns<br>
	 *<P>
   * float int casts to float & returns<br>
   * float float returns float<br>
   * float string parses as float & returns<br>
	 *<P>
   * string int makes string & returns<br>
   * string float makes string & returns<br>
   * string string returns string<br>
	 */
	/**
	 * Get the value for the field. The call's data type
   * (int, float, or string) need not match the value's
   * data type (as returned by getFieldType), except in the case of tables.
   *
   * @throws IllegalArgumentException
   * 					If the value at this index is a table.
   */
	public int getIntValue( int index )
  {
  	if (records == null)
	  	throw new NullPointerException(); //TODO exception
  	if (records[index] == null)
	  	throw new NullPointerException("Value at index is null." ); //TODO

/*TODO I'd like to do this, but the other is safer
  	if (fields[index].getType() == MetaDataField.TABLE) {
			throw new IllegalArgumentException(
				"Value at this index is a table.");
  	}
  	else if (fields[index].getType() == MetaDataField.INT) {
  	 	return ((Integer) records[index]).intValue();
  	}
  	else if (fields[index].getType() == MetaDataField.FLOAT) {
  	 	return ((Float) records[index]).intValue();
  	}
	  else {
	  	return Integer.parseInt(records[index].toString());
	  }
*/
  	if (records[index] instanceof MetaDataTable ) {
			throw new IllegalArgumentException(
				"Value at this index is a table.");
  	}
  	else if (records[index] instanceof Integer) {
  	 	return ((Integer) records[index]).intValue();
  	}
  	else if (records[index] instanceof Float) {
  	 	return ((Float) records[index]).intValue();
  	}
	  else {
	  	return Integer.parseInt(records[index].toString());
	  }
  }


	/**
	 * Get the value for the field. The call's data type
   * (int, float, or string) need not match the value's
   * data type (as returned by getFieldType), except in the case of tables.
   *
   * @throws IllegalArgumentException
   * 					If the value at this index is a table.
   */
  public float getFloatValue( int index )
  {
  	if (records == null)
	  	throw new NullPointerException(); //TODO exception
  	if (records[index] == null)
	  	throw new NullPointerException("Value at index is null." ); //TODO
/*
  	if (fields[index].getType() == MetaDataField.TABLE) {
			throw new IllegalArgumentException(
				"Value at this index is a table.");
  	}
  	else if (fields[index].getType() == MetaDataField.INT) {
  	 	return ((Integer) records[index]).floatValue();
  	}
  	else if (fields[index].getType() == MetaDataField.FLOAT) {
  	 	return ((Float) records[index]).floatValue();
  	}
	  else {
  		return Float.parseFloat(records[index].toString());
  	}
*/
  	if (records[index] instanceof MetaDataTable ) {
			throw new IllegalArgumentException(
				"Value at this index is a table.");
  	}
  	else if (records[index] instanceof Integer) {
  	 	return ((Integer) records[index]).floatValue();
  	}
  	else if (records[index] instanceof Float) {
  	 	return ((Float) records[index]).floatValue();
  	}
	  else {
	  	return Float.parseFloat(records[index].toString());
	  }
  }


	/**
	 * Get the value for the field. The call's data type
   * (int, float, or string) need not match the value's
   * data type (as returned by getFieldType), except in the case of tables.
   *
   * @throws IllegalArgumentException
   * 					If the value at this index is a table.
   */
  public String getStringValue( int index )
  {
  	if (records == null)
	  	throw new NullPointerException(); //TODO exception
  	if (records[index] == null)
	  	return null; //TODO
/*
  	if (fields[index].getType() == MetaDataField.TABLE) {
			throw new IllegalArgumentException(
				"Value at this index is a table.");
  	}
  	else if (fields[index].getType() == MetaDataField.INT) {
  	 	return records[index].toString();
  	}
  	else if (fields[index].getType() == MetaDataField.FLOAT) {
  	 	return records[index].toString();
  	}
	  else {
  		return records[index].toString();
  	}
*/
  	if (records[index] instanceof MetaDataTable ) {
			throw new IllegalArgumentException(
				"Value at this index is a table.");
  	}
  	else if (records[index] instanceof Integer) {
  	 	return records[index].toString();
  	}
  	else if (records[index] instanceof Float) {
  	 	return records[index].toString();
  	}
	  else {
	  	return records[index].toString();
	  }
  }




	/**
	 * Get the value for the field. The call's data type
   * must be a table or an IllegalArgumentException will be thrown.
   *
   * @throws IllegalArgumentException
   * 					If the value at this index is not a table.
   */
  public MetaDataTable getTableValue( int index )
  {
  	if (records == null)
	  	throw new NullPointerException(); //TODO exception
  	if (records[index] == null)
	  	return null; //TODO
/*
		if (fields[index].getType() == MetaDataField.TABLE) {
			try {
	  		return (MetaDataTable) records[index];
			} catch (ClassCastException e) {
				//only if programming error
			}
  	}
*/
  	if (records[index] instanceof MetaDataTable ) {
			try {
	  		return (MetaDataTable) records[index];
			} catch (ClassCastException e) {
				//only if programming error
			}
  	}

return null;
//		throw new IllegalArgumentException(
//			"Value at this index is not a table.");
  }


	/**
	 * Returns the values in the list.
	 */
  Object[] getAllValues( )
  {
  	return records;
  }

	/**
	 * Returns the values in the list.
	 */
  public Object getValue( int index )
  {
  	return records[index];
  }


	public Object getValue( MetaDataField field )
	{
		for (int i=0; i<fields.length; i++ ) {
			if (fields[i].equals(field)) {
				return records[i];
			}
		}

		return null;
	}

	public Object getValue( String field )
	{
		return getValue( MetaDataSet.getField( field ) );
	}



//----------------------------------------------------------------------
//  Setters and Record Modification methods
//----------------------------------------------------------------------
	public void setValue( int index, int value )
		throws ArrayIndexOutOfBoundsException
	{
		int fieldType = fields[index].getType();
		if (fieldType == MetaDataField.FLOAT) {
			records[index] = new Float( (float) value );
		}
		else if (fieldType == MetaDataField.STRING) {
			records[index] = new Integer( value ).toString();
		}
		else if (fieldType == MetaDataField.TABLE) {
			throw new IllegalArgumentException(
				fields[index]+" only accepts MetaDataTable values.");
		}
		else {
			records[index] = new Integer( value );
		}
	}

	public void setValue( int index, float value )
		throws ArrayIndexOutOfBoundsException
	{
		int fieldType = fields[index].getType();
		if (fieldType == MetaDataField.INT) {
			records[index] = new Integer( (int) value );
		}
		else if (fieldType == MetaDataField.STRING) {
			records[index] = new Float( value ).toString();
		}
		else if (fieldType == MetaDataField.TABLE) {
			throw new IllegalArgumentException(
				fields[index]+" only accepts MetaDataTable values.");
		}
		else {
			records[index] = new Float( value );
		}
	}

	public void setValue( int index, String value )
		throws ArrayIndexOutOfBoundsException
	{
		int fieldType = fields[index].getType();
		if (fieldType == MetaDataField.INT) {
			records[index] = new Integer( value );
		}
		else if (fieldType == MetaDataField.FLOAT) {
			records[index] = new String( value );
		}
		else if (fieldType == MetaDataField.TABLE) {
			throw new IllegalArgumentException(
				fields[index]+" only accepts MetaDataTable values.");
		}
		else {
			records[index] = value;
		}
	}

	public void setValue( int index, MetaDataTable value )
		throws ArrayIndexOutOfBoundsException
	{
		int fieldType = fields[index].getType();
		if (fieldType == MetaDataField.TABLE) {
			records[index] = value;
		}
		else {
			throw new IllegalArgumentException(
				fields[index]+" does not accept MetaDataTable values.");
		}
	}

	/**
	 * Changes the value in this MetaDataRecordList for the approproate
	 * <code>field</code>.
	 * Returns false if the MetaDataField does not exist in this
	 * MetaDataRecordList.
	 */
	public boolean setValue( MetaDataField field, int value )
		throws ArrayIndexOutOfBoundsException
	{
		for (int i=0; i<fields.length; i++ ) {
			if (fields[i].equals(field)) {
				setValue( i, value );
				return true;
			}
		}
		return false;
	}

	/**
	 * Changes the value in this MetaDataRecordList for the approproate
	 * <code>field</code>.
	 * Returns false if the MetaDataField does not exist in this
	 * MetaDataRecordList.
	 */
	public boolean setValue( MetaDataField field, float value )
		throws ArrayIndexOutOfBoundsException
	{
		for (int i=0; i<fields.length; i++ ) {
			if (fields[i].equals(field)) {
				setValue( i, value );
				return true;
			}
		}
		return false;
	}

	/**
	 * Changes the value in this MetaDataRecordList for the approproate
	 * <code>field</code>.
	 * Returns false if the MetaDataField does not exist in this
	 * MetaDataRecordList.
	 */
	public boolean setValue( MetaDataField field, String value )
		throws ArrayIndexOutOfBoundsException
	{
		for (int i=0; i<fields.length; i++ ) {
			if (fields[i].equals(field)) {
				setValue( i, value );
				return true;
			}
		}
		return false;
	}

	/**
	 * Changes the value in this MetaDataRecordList for the approproate
	 * <code>field</code>.
	 * Returns false if the MetaDataField does not exist in this
	 * MetaDataRecordList.
	 */
	public boolean setValue( MetaDataField field, MetaDataTable value )
		throws ArrayIndexOutOfBoundsException
	{
		for (int i=0; i<fields.length; i++ ) {
			if (fields[i].equals(field)) {
				setValue( i, value );
				return true;
			}
		}
		return false;
	}


	/**
	 *
	 */
	protected boolean addRecord( MetaDataField field, Object recordValue )
	{
		for (int i=0;i<fields.length;i++) {
			if ( fields[i].equals(field) ) {
//just overwrite duplicates?
				records[i] = recordValue;
				return false;
			}
		}



		MetaDataField[] tempFields = fields;
		Object[] tempRecords = records;
		int tempLength = tempFields.length;

		fields = new MetaDataField[tempLength+1];
		System.arraycopy(	tempFields, 0, fields,	0, tempLength);
		fields[tempLength] = field;

		records = new Object[tempLength+1];
		System.arraycopy(	tempRecords, 0, records,	0, tempLength);
		records[tempLength] = recordValue;

		return true;
	}

	/**
	 *
	 */
	public void addRecord( MetaDataField field, int recordValue )
	{
		addRecord( field, (Object) new Integer(recordValue) );
		//convert to correct Class type
		setValue( field, recordValue );
	}


	public void addRecord( MetaDataField field, float recordValue )
	{
		addRecord( field, (Object) new Float(recordValue) );
		//convert to correct Class type
		setValue( field, recordValue );
	}


	public void addRecord( MetaDataField field, String recordValue )
	{
		addRecord( field, (Object) recordValue );
		//convert to correct Class type
		setValue( field, recordValue );
	}


	public void addRecord( MetaDataField field, MetaDataTable recordValue )
	{
		if (field.getType() != MetaDataField.TABLE) {
			throw new IllegalArgumentException(
				field+" only accepts MetaDataTable values.");
		}

		addRecord( field, (Object) recordValue );
	}



	public void removeRecord( int index )
	{
		MetaDataField[] tempFields = fields;
		Object[] tempRecords = records;

		fields = new MetaDataField[tempFields.length-1];
		records = new Object[tempRecords.length-1];

		if (index > 0) {
			System.arraycopy(	tempFields, 0, fields, 0, index);
			System.arraycopy(	tempRecords, 0, records, 0, index);
		}
		System.arraycopy(	tempFields, index+1, fields, index, tempFields.length-1-index);
		System.arraycopy(	tempRecords, index+1, records,	index, tempRecords.length-1-index);
	}

	public void removeRecord( MetaDataField field )
	{
		for (int i=0; i<fields.length; i++ ) {
			if (fields[i].equals(field)) {
				removeRecord(i);
			}
		}
	}



//----------------------------------------------------------------------
//  Iterator methods
//----------------------------------------------------------------------
	/**
	 * Tests if the query has more values to be retrieved.
	 */
//TODO better name, reverse true and false
	public abstract boolean isQueryComplete();


	/**
	 * By default a query will only return the first so many values which
	 * match the query to make querying faster. If this query has more results
	 * those results will be appended to this object.
	 * @throws IOException If an IOException occurs.
	 */
	public abstract MetaDataRecordList[] getMoreResults()	throws IOException;


	/**
	 * Same as getMoreResults(), but returns <code>numOfResults</code>
	 * instead of the default amount.
	 * @throws IOException If an IOException occurs.
	 */
	public abstract MetaDataRecordList[] getMoreResults( int numOfResults )
		throws IOException;


	/**
	 * Gets all of the query results and adds them to this object.
	 */
//	public abstract MetaDataRecordList[] getAllResults() throws IOException;






}