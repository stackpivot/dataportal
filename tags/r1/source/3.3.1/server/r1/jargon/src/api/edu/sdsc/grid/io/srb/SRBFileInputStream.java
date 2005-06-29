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
//	GeneralRandomAccessFile.java	-  edu.sdsc.grid.io.GeneralRandomAccessFile
//
//  CLASS HIERARCHY
//	java.lang.Object
//	    |
//	    +-java.io.InputStream
//					|
//					+-edu.sdsc.grid.io.GeneralFileInputStream
//							|
//							+-edu.sdsc.grid.io.RemoteFileInputStream
//									|
//									+-edu.sdsc.grid.io.srb.SRBFileInputStream
//
//
//  PRINCIPAL AUTHOR
//	Lucas Gilbert, SDSC/UCSD
//
//
package edu.sdsc.grid.io.srb;


import edu.sdsc.grid.io.*;

import java.io.*;

/**
 * A SRBFileInputStream obtains input bytes from a file in a SRB file system.
 * What files are available depends on the host environment.
 *<P>
 * SRBFileInputStream is meant for reading streams of raw bytes such
 * as image data.
 *<P>
 * @author  Lucas Gilbert
 * @since   JARGON1.4
 */
public class SRBFileInputStream extends RemoteFileInputStream
{
//----------------------------------------------------------------------
//  Fields
//----------------------------------------------------------------------
	/**
	 * Position of read/write pointer in file.
	 */
	long filePointer = 0;


	/**
	 * Holds the server connection used by this stream.
	 */
	protected SRBFileSystem fileSystem;


	/**
	 * Holds the server connection used by this stream.
	 */
	private SRBFile file;


//----------------------------------------------------------------------
//  Constructors and Destructors
//----------------------------------------------------------------------
	/**
	 * Creates a <code>SRBFileInputStream</code> by
	 * opening a connection to an actual file,
	 * the file named by the path name <code>name</code>
	 * in the file system.  A new <code>FileDescriptor</code>
	 * object is created to represent this file
	 * connection.
	 * <p>
	 * First, if there is a security
	 * manager, its <code>checkRead</code> method
	 * is called with the <code>name</code> argument
	 * as its argument.
	 * <p>
	 * If the named file does not exist, is a directory rather than a regular
	 * file, or for some other reason cannot be opened for reading then a
	 * <code>IOException</code> is thrown.
	 *
	 * @param	name   the system-dependent file name.
	 * @exception  IOException  if the file does not exist,
	 *                   is a directory rather than a regular file,
	 *                   or for some other reason cannot be opened for
	 *                   reading.
	 */
	public SRBFileInputStream( SRBFileSystem fileSystem, String name )
		throws IOException
	{
		super(fileSystem, name);

		this.fileSystem = fileSystem;
	}

	/**
	 * Creates a <code>SRBFileInputStream</code> by
	 * opening a connection to an actual file,
	 * the file named by the <code>File</code>
	 * object <code>file</code> in the file system.
	 * A new <code>FileDescriptor</code> object
	 * is created to represent this file connection.
	 * <p>
	 * First, if there is a security manager,
	 * its <code>checkRead</code> method  is called
	 * with the path represented by the <code>file</code>
	 * argument as its argument.
	 * <p>
	 * If the named file does not exist, is a directory rather than a regular
	 * file, or for some other reason cannot be opened for reading then a
	 * <code>IOException</code> is thrown.
	 *
	 * @param	file   the file to be opened for reading.
	 * @exception  IOException  if the file does not exist,
	 *                   is a directory rather than a regular file,
	 *                   or for some other reason cannot be opened for
	 *                   reading.
	 * @see        java.io.File#getPath()
	 */
	public SRBFileInputStream( SRBFile file )
		throws IOException
	{
		super(file);
		fileSystem = (SRBFileSystem) file.getFileSystem();
	}




//----------------------------------------------------------------------
// Methods
//----------------------------------------------------------------------
	/**
	 * Opens the given file for use by this stream.
	 *
	 * @exception  IOException  if an I/O error occurs.
	 */
	protected void open( GeneralFile file )
		throws IOException
	{
		this.file = (SRBFile) file;
		fd = ((SRBFileSystem) file.getFileSystem()).srbObjOpen(
			file.getName(), SRBRandomAccessFile.O_RDONLY, file.getParent() );
	}


	/**
	 * Reads the next byte of data from the input stream. The value byte is
	 * returned as an <code>int</code> in the range <code>0</code> to
	 * <code>255</code>. If no byte is available because the end of the stream
	 * has been reached, the value <code>-1</code> is returned. This method
	 * blocks until input data is available, the end of the stream is detected,
	 * or an exception is thrown.
	 *
	 * <p> A subclass must provide an implementation of this method.
	 *
	 * @return     the next byte of data, or <code>-1</code> if the end of the
	 *             stream is reached.
	 * @exception  IOException  if an I/O error occurs.
	 */
	public int read()
		throws IOException
	{
		byte buffer[] = fileSystem.srbObjRead( fd, 1 );
		if (buffer != null) {
			filePointer += buffer.length;

			return buffer[0];
		}
		return -1;
	}


	/**
	 * Reads up to <code>len</code> bytes of data from the input stream into
	 * an array of bytes.  An attempt is made to read as many as
	 * <code>len</code> bytes, but a smaller number may be read, possibly
	 * zero. The number of bytes actually read is returned as an integer.
	 *
	 * <p> This method blocks until input data is available, end of file is
	 * detected, or an exception is thrown.
	 *
	 * <p> If <code>b</code> is <code>null</code>, a
	 * <code>NullPointerException</code> is thrown.
	 *
	 * <p> If <code>off</code> is negative, or <code>len</code> is negative, or
	 * <code>off+len</code> is greater than the length of the array
	 * <code>b</code>, then an <code>IndexOutOfBoundsException</code> is
	 * thrown.
	 *
	 * <p> If <code>len</code> is zero, then no bytes are read and
	 * <code>0</code> is returned; otherwise, there is an attempt to read at
	 * least one byte. If no byte is available because the stream is at end of
	 * file, the value <code>-1</code> is returned; otherwise, at least one
	 * byte is read and stored into <code>b</code>.
	 *
	 * <p> The first byte read is stored into element <code>b[off]</code>, the
	 * next one into <code>b[off+1]</code>, and so on. The number of bytes read
	 * is, at most, equal to <code>len</code>. Let <i>k</i> be the number of
	 * bytes actually read; these bytes will be stored in elements
	 * <code>b[off]</code> through <code>b[off+</code><i>k</i><code>-1]</code>,
	 * leaving elements <code>b[off+</code><i>k</i><code>]</code> through
	 * <code>b[off+len-1]</code> unaffected.
	 *
	 * <p> In every case, elements <code>b[0]</code> through
	 * <code>b[off]</code> and elements <code>b[off+len]</code> through
	 * <code>b[b.length-1]</code> are unaffected.
	 *
	 * <p> If the first byte cannot be read for any reason other than end of
	 * file, then an <code>IOException</code> is thrown. In particular, an
	 * <code>IOException</code> is thrown if the input stream has been closed.
	 *
	 * <p> The <code>read(b,</code> <code>off,</code> <code>len)</code> method
	 * for class <code>InputStream</code> simply calls the method
	 * <code>read()</code> repeatedly. If the first such call results in an
	 * <code>IOException</code>, that exception is returned from the call to
	 * the <code>read(b,</code> <code>off,</code> <code>len)</code> method.  If
	 * any subsequent call to <code>read()</code> results in a
	 * <code>IOException</code>, the exception is caught and treated as if it
	 * were end of file; the bytes read up to that point are stored into
	 * <code>b</code> and the number of bytes read before the exception
	 * occurred is returned.  Subclasses are encouraged to provide a more
	 * efficient implementation of this method.
	 *
	 * @param      b     the buffer into which the data is read.
	 * @param      off   the start offset in array <code>b</code>
	 *                   at which the data is written.
	 * @param      len   the maximum number of bytes to read.
	 * @return     the total number of bytes read into the buffer, or
	 *             <code>-1</code> if there is no more data because the end of
	 *             the stream has been reached.
	 * @exception  IOException  if an I/O error occurs.
	 * @exception  NullPointerException  if <code>b</code> is <code>null</code>.
	 * @see        java.io.InputStream#read()
	 */
	public int read(byte b[], int off, int len)
		throws IOException
	{
		byte buffer[] = null;

		buffer = fileSystem.srbObjRead( fd, len );
		if (buffer != null) {
			System.arraycopy( buffer, 0, b, off, buffer.length);
			filePointer += buffer.length;

			return buffer.length;
		}

		return -1;
	}

	/**
	 * Skips over and discards <code>n</code> bytes of data from the
	 * input stream. The <code>skip</code> method may, for a variety of
	 * reasons, end up skipping over some smaller number of bytes,
	 * possibly <code>0</code>. The actual number of bytes skipped is returned.
	 *
	 * @param	n   the number of bytes to be skipped.
	 * @return     the actual number of bytes skipped.
	 * @exception  IOException  if an I/O error occurs.
	 */
	public long skip(long n)
		throws IOException
	{
		long length = available();
		if ((filePointer + n) < length) {
			fileSystem.srbObjSeek( fd, n, GeneralRandomAccessFile.SEEK_CURRENT );
			filePointer += n;
			return n;
		}
		else {
			fileSystem.srbObjSeek(fd, length, GeneralRandomAccessFile.SEEK_CURRENT);
			filePointer += length;
			return length;
		}
	}

	/**
	 * Returns the number of bytes that can be read from this file input
	 * stream without blocking.
	 *
	 * @return     the number of bytes that can be read from this file input
	 *             stream without blocking.
	 * @exception  IOException  if an I/O error occurs.
	 */
	public int available()
		throws IOException
	{
		MetaDataRecordList[] rl = null;
		MetaDataCondition[] conditions = {
			MetaDataSet.newCondition( SRBMetaDataSet.DIRECTORY_NAME,
				MetaDataCondition.EQUAL, file.getParent() ),
			MetaDataSet.newCondition( SRBMetaDataSet.FILE_NAME,
				MetaDataCondition.EQUAL, file.getName() ) };
		MetaDataSelect[] selects = {
			MetaDataSet.newSelection( SRBMetaDataSet.SIZE ) };

		try {
			rl = fileSystem.query( conditions, selects, 3 );

			if( rl != null ) {
				//would use .getIntValue but it could be long...
				return (int) (Long.parseLong(
					rl[0].getValue(	SRBMetaDataSet.SIZE ).toString()) - filePointer);
			}
		} catch ( IOException e ) {

		}

		return 0;
	}

	/**
	 * Closes this file input stream and releases any system resources
	 * associated with the stream.
	 *<p>
	 * If this stream has an associated channel then the channel is closed
	 * as well.
	 *
	 * @exception  IOException  if an I/O error occurs.
	 */
	public void close()
		throws IOException
	{
		if (fileSystem != null) {
			fileSystem.srbObjClose( fd );
			fileSystem = null;
		}
		if (file != null)
			file = null;
	}

	/**
	 * Returns the <code>FileDescriptor</code>
	 * object  that represents the connection to
	 * the actual file in the file system being
	 * used by this <code>SRBFileInputStream</code>.
	 *
	 * @return     the file descriptor object associated with this stream.
	 * @exception  IOException  if an I/O error occurs.
	 * @see        java.io.FileDescriptor
	 */
/*    public final FileDescriptor getFD()
		throws IOException
	{

	}
*/
	/**
	 * Returns the unique {@link java.nio.channels.FileChannel FileChannel}
	 * object associated with this file input stream.
	 *
	 * <p> The initial {@link java.nio.channels.FileChannel#position()
	 * </code>position<code>} of the returned channel will be equal to the
	 * number of bytes read from the file so far.  Reading bytes from this
	 * stream will increment the channel's position.  Changing the channel's
	 * position, either explicitly or by reading, will change this stream's
	 * file position.
	 *
	 * @return  the file channel associated with this file input stream
	 */
/*
	public FileChannel getChannel()
	{

	}
*/
}