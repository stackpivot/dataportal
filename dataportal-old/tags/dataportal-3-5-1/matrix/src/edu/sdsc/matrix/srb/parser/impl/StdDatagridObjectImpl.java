//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v1.0 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2003.06.06 at 12:17:03 BST 
//


package edu.sdsc.matrix.srb.parser.impl;

public class StdDatagridObjectImpl implements edu.sdsc.matrix.srb.parser.StdDatagridObject, com.sun.xml.bind.unmarshaller.UnmarshallableObject, com.sun.xml.bind.serializer.XMLSerializable, com.sun.xml.bind.validator.ValidatableObject
{

    protected edu.sdsc.matrix.srb.parser.DataSet _DataSetNow;
    protected edu.sdsc.matrix.srb.parser.Collection _CollectionNow;
    protected edu.sdsc.matrix.srb.parser.Container _ContainerNow;
    protected edu.sdsc.matrix.srb.parser.ActiveDatagridDataSet _ActiveDataSetNow;
    protected edu.sdsc.matrix.srb.parser.ActiveDatagridCollection _ADCnow;
    private final static com.sun.msv.grammar.Grammar schemaFragment = com.sun.xml.bind.validator.SchemaDeserializer.deserialize("\u00ac\u00ed\u0000\u0005sr\u0000\u001dcom.sun.msv.grammar.ChoiceExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\u001dcom.sun.msv.grammar.BinaryExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\u0004exp1t\u0000 Lcom/sun/msv/grammar/Expression;L\u0000\u0004exp2q\u0000~\u0000\u0002xr\u0000\u001ecom.sun.msv.grammar.Expression\u00f8\u0018\u0082\u00e8N5~O\u0002\u0000\u0003I\u0000\u000ecachedHashCodeL\u0000\u0013epsilonReducibilityt\u0000\u0013Ljava/lang/Boolean;L\u0000\u000bexpandedExpq\u0000~\u0000\u0002xp\t\u000e\u0098\u00f3ppsq\u0000~\u0000\u0000\u0007>\u00e0\u00c2ppsq\u0000~\u0000\u0000\u0005o(\u0091ppsq\u0000~\u0000\u0000\u0003\u009fp`ppsr\u0000\'com.sun.msv.grammar.trex.ElementPattern\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000\tnameClasst\u0000\u001fLcom/sun/msv/grammar/NameClass;xr\u0000\u001ecom.sun.msv.grammar.ElementExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002Z\u0000\u001aignoreUndeclaredAttributesL\u0000\fcontentModelq\u0000~\u0000\u0002xq\u0000~\u0000\u0003\u0001\u00cf\u00b8/pp\u0000sq\u0000~\u0000\t\u0001\u00cf\u00b8$pp\u0000sq\u0000~\u0000\u0000\u0001\u00cf\u00b8\u0019ppsr\u0000 com.sun.msv.grammar.OneOrMoreExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\u001ccom.sun.msv.grammar.UnaryExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000\u0003expq\u0000~\u0000\u0002xq\u0000~\u0000\u0003\u0001\u00cf\u00b8\u000esr\u0000\u0011java.lang.Boolean\u00cd r\u0080\u00d5\u009c\u00fa\u00ee\u0002\u0000\u0001Z\u0000\u0005valuexp\u0000psr\u0000 com.sun.msv.grammar.AttributeExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\u0003expq\u0000~\u0000\u0002L\u0000\tnameClassq\u0000~\u0000\nxq\u0000~\u0000\u0003\u0001\u00cf\u00b8\u000bq\u0000~\u0000\u0013psr\u00002com.sun.msv.grammar.Expression$AnyStringExpression\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0003\u0000\u0000\u0000\bsq\u0000~\u0000\u0012\u0001q\u0000~\u0000\u0017sr\u0000 com.sun.msv.grammar.AnyNameClass\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\u001dcom.sun.msv.grammar.NameClass\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xpsr\u00000com.sun.msv.grammar.Expression$EpsilonExpression\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0003\u0000\u0000\u0000\tq\u0000~\u0000\u0018psr\u0000#com.sun.msv.grammar.SimpleNameClass\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\tlocalNamet\u0000\u0012Ljava/lang/String;L\u0000\fnamespaceURIq\u0000~\u0000\u001fxq\u0000~\u0000\u001at\u0000%edu.sdsc.matrix.srb.parser.Collectiont\u0000+http://java.sun.com/jaxb/xjc/dummy-elementssq\u0000~\u0000\u001et\u0000\rCollectionNowt\u0000(http://www.teragrid.org/schemas/datagridsq\u0000~\u0000\t\u0001\u00cf\u00b8/pp\u0000sq\u0000~\u0000\t\u0001\u00cf\u00b8$pp\u0000sq\u0000~\u0000\u0000\u0001\u00cf\u00b8\u0019ppsq\u0000~\u0000\u000f\u0001\u00cf\u00b8\u000eq\u0000~\u0000\u0013psq\u0000~\u0000\u0014\u0001\u00cf\u00b8\u000bq\u0000~\u0000\u0013pq\u0000~\u0000\u0017q\u0000~\u0000\u001bq\u0000~\u0000\u001dsq\u0000~\u0000\u001et\u0000\"edu.sdsc.matrix.srb.parser.DataSetq\u0000~\u0000\"sq\u0000~\u0000\u001et\u0000\nDataSetNowq\u0000~\u0000%sq\u0000~\u0000\t\u0001\u00cf\u00b8/pp\u0000sq\u0000~\u0000\t\u0001\u00cf\u00b8$pp\u0000sq\u0000~\u0000\u0000\u0001\u00cf\u00b8\u0019ppsq\u0000~\u0000\u000f\u0001\u00cf\u00b8\u000eq\u0000~\u0000\u0013psq\u0000~\u0000\u0014\u0001\u00cf\u00b8\u000bq\u0000~\u0000\u0013pq\u0000~\u0000\u0017q\u0000~\u0000\u001bq\u0000~\u0000\u001dsq\u0000~\u0000\u001et\u0000$edu.sdsc.matrix.srb.parser.Containerq\u0000~\u0000\"sq\u0000~\u0000\u001et\u0000\fContainerNowq\u0000~\u0000%sq\u0000~\u0000\t\u0001\u00cf\u00b8/pp\u0000sq\u0000~\u0000\t\u0001\u00cf\u00b8$pp\u0000sq\u0000~\u0000\u0000\u0001\u00cf\u00b8\u0019ppsq\u0000~\u0000\u000f\u0001\u00cf\u00b8\u000eq\u0000~\u0000\u0013psq\u0000~\u0000\u0014\u0001\u00cf\u00b8\u000bq\u0000~\u0000\u0013pq\u0000~\u0000\u0017q\u0000~\u0000\u001bq\u0000~\u0000\u001dsq\u0000~\u0000\u001et\u00003edu.sdsc.matrix.srb.parser.ActiveDatagridCollectionq\u0000~\u0000\"sq\u0000~\u0000\u001et\u0000\u0006ADCnowq\u0000~\u0000%sq\u0000~\u0000\t\u0001\u00cf\u00b8/pp\u0000sq\u0000~\u0000\t\u0001\u00cf\u00b8$pp\u0000sq\u0000~\u0000\u0000\u0001\u00cf\u00b8\u0019ppsq\u0000~\u0000\u000f\u0001\u00cf\u00b8\u000eq\u0000~\u0000\u0013psq\u0000~\u0000\u0014\u0001\u00cf\u00b8\u000bq\u0000~\u0000\u0013pq\u0000~\u0000\u0017q\u0000~\u0000\u001bq\u0000~\u0000\u001dsq\u0000~\u0000\u001et\u00000edu.sdsc.matrix.srb.parser.ActiveDatagridDataSetq\u0000~\u0000\"sq\u0000~\u0000\u001et\u0000\u0010ActiveDataSetNowq\u0000~\u0000%sr\u0000\"com.sun.msv.grammar.ExpressionPool\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000\bexpTablet\u0000/Lcom/sun/msv/grammar/ExpressionPool$ClosedHash;xpsr\u0000-com.sun.msv.grammar.ExpressionPool$ClosedHash\u00d7j\u00d0N\u00ef\u00e8\u00ed\u001c\u0002\u0000\u0004I\u0000\u0005countI\u0000\tthresholdL\u0000\u0006parentq\u0000~\u0000K[\u0000\u0005tablet\u0000![Lcom/sun/msv/grammar/Expression;xp\u0000\u0000\u0000\u000e\u0000\u0000\u00009pur\u0000![Lcom.sun.msv.grammar.Expression;\u00d68D\u00c3]\u00ad\u00a7\n\u0002\u0000\u0000xp\u0000\u0000\u0000\u00bfpppppppppppppppppppppppppq\u0000~\u0000\u0005pppppppppppppppppppppq\u0000~\u0000\bpppppppppppppppppppppppppppppppppppppq\u0000~\u0000\u0011q\u0000~\u0000)q\u0000~\u00002q\u0000~\u0000;q\u0000~\u0000Dppppppq\u0000~\u0000\u000eq\u0000~\u0000(q\u0000~\u00001q\u0000~\u0000:q\u0000~\u0000\u0006q\u0000~\u0000Cpppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppq\u0000~\u0000\u0007ppppppppppppppppppppppp");

    private final static java.lang.Class PRIMARY_INTERFACE_CLASS() {
        return edu.sdsc.matrix.srb.parser.StdDatagridObject.class;
    }

    public edu.sdsc.matrix.srb.parser.DataSet getDataSetNow() {
        return _DataSetNow;
    }

    public void setDataSetNow(edu.sdsc.matrix.srb.parser.DataSet value) {
        _DataSetNow = value;
    }

    public edu.sdsc.matrix.srb.parser.Collection getCollectionNow() {
        return _CollectionNow;
    }

    public void setCollectionNow(edu.sdsc.matrix.srb.parser.Collection value) {
        _CollectionNow = value;
    }

    public edu.sdsc.matrix.srb.parser.Container getContainerNow() {
        return _ContainerNow;
    }

    public void setContainerNow(edu.sdsc.matrix.srb.parser.Container value) {
        _ContainerNow = value;
    }

    public edu.sdsc.matrix.srb.parser.ActiveDatagridDataSet getActiveDataSetNow() {
        return _ActiveDataSetNow;
    }

    public void setActiveDataSetNow(edu.sdsc.matrix.srb.parser.ActiveDatagridDataSet value) {
        _ActiveDataSetNow = value;
    }

    public edu.sdsc.matrix.srb.parser.ActiveDatagridCollection getADCnow() {
        return _ADCnow;
    }

    public void setADCnow(edu.sdsc.matrix.srb.parser.ActiveDatagridCollection value) {
        _ADCnow = value;
    }

    public com.sun.xml.bind.unmarshaller.ContentHandlerEx getUnmarshaller(com.sun.xml.bind.unmarshaller.UnmarshallingContext context) {
        return new edu.sdsc.matrix.srb.parser.impl.StdDatagridObjectImpl.Unmarshaller(context);
    }

    public java.lang.Class getPrimaryInterfaceClass() {
        return PRIMARY_INTERFACE_CLASS();
    }

    public void serializeElements(com.sun.xml.bind.serializer.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
        if (((((_ADCnow == null)&&(_CollectionNow!= null))&&(_ContainerNow == null))&&(_ActiveDataSetNow == null))&&(_DataSetNow == null)) {
            if (_CollectionNow instanceof javax.xml.bind.Element) {
                context.childAsElements(((com.sun.xml.bind.serializer.XMLSerializable) _CollectionNow));
            } else {
                context.startElement("http://www.teragrid.org/schemas/datagrid", "CollectionNow");
                context.childAsAttributes(((com.sun.xml.bind.serializer.XMLSerializable) _CollectionNow));
                context.endAttributes();
                context.childAsElements(((com.sun.xml.bind.serializer.XMLSerializable) _CollectionNow));
                context.endElement();
            }
        } else {
            if (((((_ADCnow == null)&&(_CollectionNow == null))&&(_ContainerNow == null))&&(_ActiveDataSetNow == null))&&(_DataSetNow!= null)) {
                if (_DataSetNow instanceof javax.xml.bind.Element) {
                    context.childAsElements(((com.sun.xml.bind.serializer.XMLSerializable) _DataSetNow));
                } else {
                    context.startElement("http://www.teragrid.org/schemas/datagrid", "DataSetNow");
                    context.childAsAttributes(((com.sun.xml.bind.serializer.XMLSerializable) _DataSetNow));
                    context.endAttributes();
                    context.childAsElements(((com.sun.xml.bind.serializer.XMLSerializable) _DataSetNow));
                    context.endElement();
                }
            } else {
                if (((((_ADCnow == null)&&(_CollectionNow == null))&&(_ContainerNow!= null))&&(_ActiveDataSetNow == null))&&(_DataSetNow == null)) {
                    if (_ContainerNow instanceof javax.xml.bind.Element) {
                        context.childAsElements(((com.sun.xml.bind.serializer.XMLSerializable) _ContainerNow));
                    } else {
                        context.startElement("http://www.teragrid.org/schemas/datagrid", "ContainerNow");
                        context.childAsAttributes(((com.sun.xml.bind.serializer.XMLSerializable) _ContainerNow));
                        context.endAttributes();
                        context.childAsElements(((com.sun.xml.bind.serializer.XMLSerializable) _ContainerNow));
                        context.endElement();
                    }
                } else {
                    if (((((_ADCnow!= null)&&(_CollectionNow == null))&&(_ContainerNow == null))&&(_ActiveDataSetNow == null))&&(_DataSetNow == null)) {
                        if (_ADCnow instanceof javax.xml.bind.Element) {
                            context.childAsElements(((com.sun.xml.bind.serializer.XMLSerializable) _ADCnow));
                        } else {
                            context.startElement("http://www.teragrid.org/schemas/datagrid", "ADCnow");
                            context.childAsAttributes(((com.sun.xml.bind.serializer.XMLSerializable) _ADCnow));
                            context.endAttributes();
                            context.childAsElements(((com.sun.xml.bind.serializer.XMLSerializable) _ADCnow));
                            context.endElement();
                        }
                    } else {
                        if (((((_ADCnow == null)&&(_CollectionNow == null))&&(_ContainerNow == null))&&(_ActiveDataSetNow!= null))&&(_DataSetNow == null)) {
                            if (_ActiveDataSetNow instanceof javax.xml.bind.Element) {
                                context.childAsElements(((com.sun.xml.bind.serializer.XMLSerializable) _ActiveDataSetNow));
                            } else {
                                context.startElement("http://www.teragrid.org/schemas/datagrid", "ActiveDataSetNow");
                                context.childAsAttributes(((com.sun.xml.bind.serializer.XMLSerializable) _ActiveDataSetNow));
                                context.endAttributes();
                                context.childAsElements(((com.sun.xml.bind.serializer.XMLSerializable) _ActiveDataSetNow));
                                context.endElement();
                            }
                        }
                    }
                }
            }
        }
    }

    public void serializeAttributes(com.sun.xml.bind.serializer.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
    }

    public void serializeAttributeBodies(com.sun.xml.bind.serializer.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
    }

    public java.lang.Class getPrimaryInterface() {
        return (edu.sdsc.matrix.srb.parser.StdDatagridObject.class);
    }

    public com.sun.msv.verifier.DocumentDeclaration createRawValidator() {
        return new com.sun.msv.verifier.regexp.REDocumentDeclaration(schemaFragment);
    }

    public class Unmarshaller
        extends com.sun.xml.bind.unmarshaller.ContentHandlerEx
    {


        public Unmarshaller(com.sun.xml.bind.unmarshaller.UnmarshallingContext context) {
            super(context, "------------");
        }

        protected com.sun.xml.bind.unmarshaller.UnmarshallableObject owner() {
            return edu.sdsc.matrix.srb.parser.impl.StdDatagridObjectImpl.this;
        }

        public void enterElement(java.lang.String ___uri, java.lang.String ___local, org.xml.sax.Attributes __atts)
            throws com.sun.xml.bind.unmarshaller.UnreportedException
        {
            switch (state) {
                case  8 :
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("AnyDirectory" == ___local)) {
                        _CollectionNow = ((edu.sdsc.matrix.srb.parser.impl.CollectionImpl) spawnChildFromEnterElement((edu.sdsc.matrix.srb.parser.impl.CollectionImpl.class), 9, ___uri, ___local, __atts));
                        return ;
                    }
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("StdCollection" == ___local)) {
                        _CollectionNow = ((edu.sdsc.matrix.srb.parser.impl.CollectionImpl) spawnChildFromEnterElement((edu.sdsc.matrix.srb.parser.impl.CollectionImpl.class), 9, ___uri, ___local, __atts));
                        return ;
                    }
                    break;
                case  3 :
                    revertToParentFromEnterElement(___uri, ___local, __atts);
                    return ;
                case  10 :
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("collection" == ___local)) {
                        _ADCnow = ((edu.sdsc.matrix.srb.parser.impl.ActiveDatagridCollectionImpl) spawnChildFromEnterElement((edu.sdsc.matrix.srb.parser.impl.ActiveDatagridCollectionImpl.class), 11, ___uri, ___local, __atts));
                        return ;
                    }
                    break;
                case  4 :
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("dataIdentifier" == ___local)) {
                        _DataSetNow = ((edu.sdsc.matrix.srb.parser.impl.DataSetImpl) spawnChildFromEnterElement((edu.sdsc.matrix.srb.parser.impl.DataSetImpl.class), 5, ___uri, ___local, __atts));
                        return ;
                    }
                    break;
                case  1 :
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("dataSet" == ___local)) {
                        _ActiveDataSetNow = ((edu.sdsc.matrix.srb.parser.impl.ActiveDatagridDataSetImpl) spawnChildFromEnterElement((edu.sdsc.matrix.srb.parser.impl.ActiveDatagridDataSetImpl.class), 2, ___uri, ___local, __atts));
                        return ;
                    }
                    break;
                case  6 :
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("containerName" == ___local)) {
                        _ContainerNow = ((edu.sdsc.matrix.srb.parser.impl.ContainerImpl) spawnChildFromEnterElement((edu.sdsc.matrix.srb.parser.impl.ContainerImpl.class), 7, ___uri, ___local, __atts));
                        return ;
                    }
                    break;
                case  0 :
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("DataSetNow" == ___local)) {
                        context.pushAttributes(__atts);
                        state = 4;
                        return ;
                    }
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("CollectionNow" == ___local)) {
                        context.pushAttributes(__atts);
                        state = 8;
                        return ;
                    }
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("ADCnow" == ___local)) {
                        context.pushAttributes(__atts);
                        state = 10;
                        return ;
                    }
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("ActiveDataSetNow" == ___local)) {
                        context.pushAttributes(__atts);
                        state = 1;
                        return ;
                    }
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("ContainerNow" == ___local)) {
                        context.pushAttributes(__atts);
                        state = 6;
                        return ;
                    }
                    break;
            }
            super.enterElement(___uri, ___local, __atts);
        }

        public void leaveElement(java.lang.String ___uri, java.lang.String ___local)
            throws com.sun.xml.bind.unmarshaller.UnreportedException
        {
            switch (state) {
                case  3 :
                    revertToParentFromLeaveElement(___uri, ___local);
                    return ;
                case  2 :
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("ActiveDataSetNow" == ___local)) {
                        context.popAttributes();
                        state = 3;
                        return ;
                    }
                    break;
                case  9 :
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("CollectionNow" == ___local)) {
                        context.popAttributes();
                        state = 3;
                        return ;
                    }
                    break;
                case  7 :
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("ContainerNow" == ___local)) {
                        context.popAttributes();
                        state = 3;
                        return ;
                    }
                    break;
                case  5 :
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("DataSetNow" == ___local)) {
                        context.popAttributes();
                        state = 3;
                        return ;
                    }
                    break;
                case  11 :
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("ADCnow" == ___local)) {
                        context.popAttributes();
                        state = 3;
                        return ;
                    }
                    break;
            }
            super.leaveElement(___uri, ___local);
        }

        public void enterAttribute(java.lang.String ___uri, java.lang.String ___local)
            throws com.sun.xml.bind.unmarshaller.UnreportedException
        {
            switch (state) {
                case  3 :
                    revertToParentFromEnterAttribute(___uri, ___local);
                    return ;
            }
            super.enterAttribute(___uri, ___local);
        }

        public void leaveAttribute(java.lang.String ___uri, java.lang.String ___local)
            throws com.sun.xml.bind.unmarshaller.UnreportedException
        {
            switch (state) {
                case  3 :
                    revertToParentFromLeaveAttribute(___uri, ___local);
                    return ;
            }
            super.leaveAttribute(___uri, ___local);
        }

        public void text(java.lang.String value)
            throws com.sun.xml.bind.unmarshaller.UnreportedException
        {
            try {
                switch (state) {
                    case  3 :
                        revertToParentFromText(value);
                        return ;
                }
            } catch (java.lang.RuntimeException e) {
                handleUnexpectedTextException(value, e);
            }
        }

        public void leaveChild(int nextState)
            throws com.sun.xml.bind.unmarshaller.UnreportedException
        {
            switch (nextState) {
                case  2 :
                    state = 2;
                    return ;
                case  9 :
                    state = 9;
                    return ;
                case  7 :
                    state = 7;
                    return ;
                case  5 :
                    state = 5;
                    return ;
                case  11 :
                    state = 11;
                    return ;
            }
            super.leaveChild(nextState);
        }

    }

}