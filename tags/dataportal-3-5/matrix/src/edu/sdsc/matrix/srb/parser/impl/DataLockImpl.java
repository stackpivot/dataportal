//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v1.0 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2003.06.06 at 12:17:03 BST 
//


package edu.sdsc.matrix.srb.parser.impl;

public class DataLockImpl implements edu.sdsc.matrix.srb.parser.DataLock, com.sun.xml.bind.unmarshaller.UnmarshallableObject, com.sun.xml.bind.serializer.XMLSerializable, com.sun.xml.bind.validator.ValidatableObject
{

    protected java.util.Calendar _LockEndTimeStamp;
    protected java.util.Calendar _LockStartTimeStamp;
    protected java.lang.String _LockDescription;
    protected boolean has_LockNum;
    protected int _LockNum;
    protected edu.sdsc.matrix.srb.parser.UserInfo _LockOwner;
    private final static com.sun.msv.grammar.Grammar schemaFragment = com.sun.xml.bind.validator.SchemaDeserializer.deserialize("\u00ac\u00ed\u0000\u0005sr\u0000\u001fcom.sun.msv.grammar.SequenceExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\u001dcom.sun.msv.grammar.BinaryExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\u0004exp1t\u0000 Lcom/sun/msv/grammar/Expression;L\u0000\u0004exp2q\u0000~\u0000\u0002xr\u0000\u001ecom.sun.msv.grammar.Expression\u00f8\u0018\u0082\u00e8N5~O\u0002\u0000\u0003I\u0000\u000ecachedHashCodeL\u0000\u0013epsilonReducibilityt\u0000\u0013Ljava/lang/Boolean;L\u0000\u000bexpandedExpq\u0000~\u0000\u0002xp\b\u000f\u00dd\u00f2ppsq\u0000~\u0000\u0000\u0006}kRppsq\u0000~\u0000\u0000\u0004\u00ea\u00f8\u00b2ppsq\u0000~\u0000\u0000\u00034k\u000fppsr\u0000\'com.sun.msv.grammar.trex.ElementPattern\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000\tnameClasst\u0000\u001fLcom/sun/msv/grammar/NameClass;xr\u0000\u001ecom.sun.msv.grammar.ElementExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002Z\u0000\u001aignoreUndeclaredAttributesL\u0000\fcontentModelq\u0000~\u0000\u0002xq\u0000~\u0000\u0003\u0001d\u00b2\u00dbpp\u0000sr\u0000\u001bcom.sun.msv.grammar.DataExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0003L\u0000\u0002dtt\u0000\u001fLorg/relaxng/datatype/Datatype;L\u0000\u0006exceptq\u0000~\u0000\u0002L\u0000\u0004namet\u0000\u001dLcom/sun/msv/util/StringPair;xq\u0000~\u0000\u0003\u0001d\u00b2\u00d0sr\u0000\u0011java.lang.Boolean\u00cd r\u0080\u00d5\u009c\u00fa\u00ee\u0002\u0000\u0001Z\u0000\u0005valuexp\u0000psr\u0000 com.sun.msv.datatype.xsd.IntType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000+com.sun.msv.datatype.xsd.IntegerDerivedType\u0099\u00f1]\u0090&6k\u00be\u0002\u0000\u0000xr\u0000*com.sun.msv.datatype.xsd.BuiltinAtomicType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000%com.sun.msv.datatype.xsd.ConcreteType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\'com.sun.msv.datatype.xsd.XSDatatypeImpl\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0003L\u0000\fnamespaceUrit\u0000\u0012Ljava/lang/String;L\u0000\btypeNameq\u0000~\u0000\u0018L\u0000\nwhiteSpacet\u0000.Lcom/sun/msv/datatype/xsd/WhiteSpaceProcessor;xpt\u0000 http://www.w3.org/2001/XMLSchemat\u0000\u0003intsr\u0000.com.sun.msv.datatype.xsd.WhiteSpaceProcessor$2\u0087z9\u00ee\u00f8,N\u0005\u0002\u0000\u0000xr\u0000,com.sun.msv.datatype.xsd.WhiteSpaceProcessor\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xpsr\u00000com.sun.msv.grammar.Expression$NullSetExpression\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0003\u0000\u0000\u0000\nq\u0000~\u0000\u0012psr\u0000\u001bcom.sun.msv.util.StringPair\u00d0t\u001ejB\u008f\u008d\u00a0\u0002\u0000\u0002L\u0000\tlocalNameq\u0000~\u0000\u0018L\u0000\fnamespaceURIq\u0000~\u0000\u0018xpq\u0000~\u0000\u001cq\u0000~\u0000\u001bsr\u0000#com.sun.msv.grammar.SimpleNameClass\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\tlocalNameq\u0000~\u0000\u0018L\u0000\fnamespaceURIq\u0000~\u0000\u0018xr\u0000\u001dcom.sun.msv.grammar.NameClass\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xpt\u0000\u0007lockNumt\u0000(http://www.teragrid.org/schemas/datagridsq\u0000~\u0000\t\u0001\u00cf\u00b8/pp\u0000sq\u0000~\u0000\t\u0001\u00cf\u00b8$pp\u0000sr\u0000\u001dcom.sun.msv.grammar.ChoiceExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0001\u0001\u00cf\u00b8\u0019ppsr\u0000 com.sun.msv.grammar.OneOrMoreExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\u001ccom.sun.msv.grammar.UnaryExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000\u0003expq\u0000~\u0000\u0002xq\u0000~\u0000\u0003\u0001\u00cf\u00b8\u000eq\u0000~\u0000\u0012psr\u0000 com.sun.msv.grammar.AttributeExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\u0003expq\u0000~\u0000\u0002L\u0000\tnameClassq\u0000~\u0000\nxq\u0000~\u0000\u0003\u0001\u00cf\u00b8\u000bq\u0000~\u0000\u0012psr\u00002com.sun.msv.grammar.Expression$AnyStringExpression\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0003\u0000\u0000\u0000\bsq\u0000~\u0000\u0011\u0001q\u0000~\u00003sr\u0000 com.sun.msv.grammar.AnyNameClass\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000%sr\u00000com.sun.msv.grammar.Expression$EpsilonExpression\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0003\u0000\u0000\u0000\tq\u0000~\u00004psq\u0000~\u0000$t\u0000#edu.sdsc.matrix.srb.parser.UserInfot\u0000+http://java.sun.com/jaxb/xjc/dummy-elementssq\u0000~\u0000$t\u0000\tlockOwnerq\u0000~\u0000(sq\u0000~\u0000+\u0001\u00b6\u008d\u009eppsq\u0000~\u0000\t\u0001\u00b6\u008d\u0093q\u0000~\u0000\u0012p\u0000sq\u0000~\u0000\r\u0001\u00b6\u008d\u0088q\u0000~\u0000\u0012psr\u0000#com.sun.msv.datatype.xsd.StringType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001Z\u0000\risAlwaysValidxq\u0000~\u0000\u0015q\u0000~\u0000\u001bt\u0000\u0006stringsr\u0000.com.sun.msv.datatype.xsd.WhiteSpaceProcessor$1\u0013JMoI\u00db\u00a4G\u0002\u0000\u0000xq\u0000~\u0000\u001e\u0001q\u0000~\u0000!sq\u0000~\u0000\"q\u0000~\u0000Cq\u0000~\u0000\u001bsq\u0000~\u0000$t\u0000\u000flockDescriptionq\u0000~\u0000(q\u0000~\u00008sq\u0000~\u0000+\u0001\u0092r\u009bppsq\u0000~\u0000\t\u0001\u0092r\u0090q\u0000~\u0000\u0012p\u0000sq\u0000~\u0000\r\u0001\u0092r\u0085ppsr\u0000%com.sun.msv.datatype.xsd.DateTimeType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000)com.sun.msv.datatype.xsd.DateTimeBaseType\u0014W\u001a@3\u00a5\u00b4\u00e5\u0002\u0000\u0000xq\u0000~\u0000\u0015q\u0000~\u0000\u001bt\u0000\bdateTimeq\u0000~\u0000\u001fq\u0000~\u0000!sq\u0000~\u0000\"q\u0000~\u0000Oq\u0000~\u0000\u001bsq\u0000~\u0000$t\u0000\u0012lockStartTimeStampq\u0000~\u0000(q\u0000~\u00008sq\u0000~\u0000+\u0001\u0092r\u009bppsq\u0000~\u0000\t\u0001\u0092r\u0090q\u0000~\u0000\u0012p\u0000q\u0000~\u0000Ksq\u0000~\u0000$t\u0000\u0010lockEndTimeStampq\u0000~\u0000(q\u0000~\u00008sr\u0000\"com.sun.msv.grammar.ExpressionPool\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000\bexpTablet\u0000/Lcom/sun/msv/grammar/ExpressionPool$ClosedHash;xpsr\u0000-com.sun.msv.grammar.ExpressionPool$ClosedHash\u00d7j\u00d0N\u00ef\u00e8\u00ed\u001c\u0002\u0000\u0004I\u0000\u0005countI\u0000\tthresholdL\u0000\u0006parentq\u0000~\u0000X[\u0000\u0005tablet\u0000![Lcom/sun/msv/grammar/Expression;xp\u0000\u0000\u0000\t\u0000\u0000\u00009pur\u0000![Lcom.sun.msv.grammar.Expression;\u00d68D\u00c3]\u00ad\u00a7\n\u0002\u0000\u0000xp\u0000\u0000\u0000\u00bfpppq\u0000~\u0000Iq\u0000~\u0000Sppppppppppppppppppppppppppppppppppppppppq\u0000~\u0000\bpppppppppppppppppppppppppppppppppppppppq\u0000~\u0000/ppppppppppq\u0000~\u0000,pppppppppq\u0000~\u0000>pppppppppppppppppppppppppppppppppppppppppppppppppq\u0000~\u0000\u0007pppppppq\u0000~\u0000\u0006pppppppq\u0000~\u0000\u0005pppppppppppppppppp");

    private final static java.lang.Class PRIMARY_INTERFACE_CLASS() {
        return edu.sdsc.matrix.srb.parser.DataLock.class;
    }

    public java.util.Calendar getLockEndTimeStamp() {
        return _LockEndTimeStamp;
    }

    public void setLockEndTimeStamp(java.util.Calendar value) {
        _LockEndTimeStamp = value;
    }

    public java.util.Calendar getLockStartTimeStamp() {
        return _LockStartTimeStamp;
    }

    public void setLockStartTimeStamp(java.util.Calendar value) {
        _LockStartTimeStamp = value;
    }

    public java.lang.String getLockDescription() {
        return _LockDescription;
    }

    public void setLockDescription(java.lang.String value) {
        _LockDescription = value;
    }

    public int getLockNum() {
        return _LockNum;
    }

    public void setLockNum(int value) {
        _LockNum = value;
        has_LockNum = true;
    }

    public edu.sdsc.matrix.srb.parser.UserInfo getLockOwner() {
        return _LockOwner;
    }

    public void setLockOwner(edu.sdsc.matrix.srb.parser.UserInfo value) {
        _LockOwner = value;
    }

    public com.sun.xml.bind.unmarshaller.ContentHandlerEx getUnmarshaller(com.sun.xml.bind.unmarshaller.UnmarshallingContext context) {
        return new edu.sdsc.matrix.srb.parser.impl.DataLockImpl.Unmarshaller(context);
    }

    public java.lang.Class getPrimaryInterfaceClass() {
        return PRIMARY_INTERFACE_CLASS();
    }

    public void serializeElements(com.sun.xml.bind.serializer.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
        context.startElement("http://www.teragrid.org/schemas/datagrid", "lockNum");
        context.endAttributes();
        try {
            context.text(javax.xml.bind.DatatypeConverter.printInt(((int) _LockNum)));
        } catch (java.lang.Exception e) {
            com.sun.xml.bind.marshaller.Util.handlePrintConversionException(this, e, context);
        }
        context.endElement();
        if (_LockOwner instanceof javax.xml.bind.Element) {
            context.childAsElements(((com.sun.xml.bind.serializer.XMLSerializable) _LockOwner));
        } else {
            context.startElement("http://www.teragrid.org/schemas/datagrid", "lockOwner");
            context.childAsAttributes(((com.sun.xml.bind.serializer.XMLSerializable) _LockOwner));
            context.endAttributes();
            context.childAsElements(((com.sun.xml.bind.serializer.XMLSerializable) _LockOwner));
            context.endElement();
        }
        if (_LockDescription!= null) {
            context.startElement("http://www.teragrid.org/schemas/datagrid", "lockDescription");
            context.endAttributes();
            try {
                context.text(((java.lang.String) _LockDescription));
            } catch (java.lang.Exception e) {
                com.sun.xml.bind.marshaller.Util.handlePrintConversionException(this, e, context);
            }
            context.endElement();
        }
        if (_LockStartTimeStamp!= null) {
            context.startElement("http://www.teragrid.org/schemas/datagrid", "lockStartTimeStamp");
            context.endAttributes();
            try {
                context.text(com.sun.msv.datatype.xsd.DateTimeType.theInstance.serializeJavaObject(((java.util.Calendar) _LockStartTimeStamp), null));
            } catch (java.lang.Exception e) {
                com.sun.xml.bind.marshaller.Util.handlePrintConversionException(this, e, context);
            }
            context.endElement();
        }
        if (_LockEndTimeStamp!= null) {
            context.startElement("http://www.teragrid.org/schemas/datagrid", "lockEndTimeStamp");
            context.endAttributes();
            try {
                context.text(com.sun.msv.datatype.xsd.DateTimeType.theInstance.serializeJavaObject(((java.util.Calendar) _LockEndTimeStamp), null));
            } catch (java.lang.Exception e) {
                com.sun.xml.bind.marshaller.Util.handlePrintConversionException(this, e, context);
            }
            context.endElement();
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
        return (edu.sdsc.matrix.srb.parser.DataLock.class);
    }

    public com.sun.msv.verifier.DocumentDeclaration createRawValidator() {
        return new com.sun.msv.verifier.regexp.REDocumentDeclaration(schemaFragment);
    }

    public class Unmarshaller
        extends com.sun.xml.bind.unmarshaller.ContentHandlerEx
    {


        public Unmarshaller(com.sun.xml.bind.unmarshaller.UnmarshallingContext context) {
            super(context, "-------------");
        }

        protected com.sun.xml.bind.unmarshaller.UnmarshallableObject owner() {
            return edu.sdsc.matrix.srb.parser.impl.DataLockImpl.this;
        }

        public void enterElement(java.lang.String ___uri, java.lang.String ___local, org.xml.sax.Attributes __atts)
            throws com.sun.xml.bind.unmarshaller.UnreportedException
        {
            switch (state) {
                case  4 :
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("gridTicket" == ___local)) {
                        _LockOwner = ((edu.sdsc.matrix.srb.parser.impl.UserInfoImpl) spawnChildFromEnterElement((edu.sdsc.matrix.srb.parser.impl.UserInfoImpl.class), 5, ___uri, ___local, __atts));
                        return ;
                    }
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("userID" == ___local)) {
                        _LockOwner = ((edu.sdsc.matrix.srb.parser.impl.UserInfoImpl) spawnChildFromEnterElement((edu.sdsc.matrix.srb.parser.impl.UserInfoImpl.class), 5, ___uri, ___local, __atts));
                        return ;
                    }
                    break;
                case  6 :
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("lockStartTimeStamp" == ___local)) {
                        context.pushAttributes(__atts);
                        state = 7;
                        return ;
                    }
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("lockDescription" == ___local)) {
                        context.pushAttributes(__atts);
                        state = 9;
                        return ;
                    }
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("lockEndTimeStamp" == ___local)) {
                        context.pushAttributes(__atts);
                        state = 11;
                        return ;
                    }
                    revertToParentFromEnterElement(___uri, ___local, __atts);
                    return ;
                case  0 :
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("lockNum" == ___local)) {
                        context.pushAttributes(__atts);
                        state = 1;
                        return ;
                    }
                    break;
                case  3 :
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("lockOwner" == ___local)) {
                        context.pushAttributes(__atts);
                        state = 4;
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
                case  10 :
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("lockDescription" == ___local)) {
                        context.popAttributes();
                        state = 6;
                        return ;
                    }
                    break;
                case  8 :
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("lockStartTimeStamp" == ___local)) {
                        context.popAttributes();
                        state = 6;
                        return ;
                    }
                    break;
                case  6 :
                    revertToParentFromLeaveElement(___uri, ___local);
                    return ;
                case  2 :
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("lockNum" == ___local)) {
                        context.popAttributes();
                        state = 3;
                        return ;
                    }
                    break;
                case  12 :
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("lockEndTimeStamp" == ___local)) {
                        context.popAttributes();
                        state = 6;
                        return ;
                    }
                    break;
                case  5 :
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("lockOwner" == ___local)) {
                        context.popAttributes();
                        state = 6;
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
                case  6 :
                    revertToParentFromEnterAttribute(___uri, ___local);
                    return ;
            }
            super.enterAttribute(___uri, ___local);
        }

        public void leaveAttribute(java.lang.String ___uri, java.lang.String ___local)
            throws com.sun.xml.bind.unmarshaller.UnreportedException
        {
            switch (state) {
                case  6 :
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
                    case  11 :
                        try {
                            _LockEndTimeStamp = ((java.util.Calendar) com.sun.msv.datatype.xsd.DateTimeType.theInstance.createJavaObject(value, context));
                        } catch (java.lang.Exception e) {
                            handleParseConversionException(e);
                        }
                        state = 12;
                        return ;
                    case  7 :
                        try {
                            _LockStartTimeStamp = ((java.util.Calendar) com.sun.msv.datatype.xsd.DateTimeType.theInstance.createJavaObject(value, context));
                        } catch (java.lang.Exception e) {
                            handleParseConversionException(e);
                        }
                        state = 8;
                        return ;
                    case  6 :
                        revertToParentFromText(value);
                        return ;
                    case  9 :
                        try {
                            _LockDescription = value;
                        } catch (java.lang.Exception e) {
                            handleParseConversionException(e);
                        }
                        state = 10;
                        return ;
                    case  1 :
                        try {
                            _LockNum = javax.xml.bind.DatatypeConverter.parseInt(com.sun.xml.bind.WhiteSpaceProcessor.collapse(value));
                            has_LockNum = true;
                        } catch (java.lang.Exception e) {
                            handleParseConversionException(e);
                        }
                        state = 2;
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
                case  5 :
                    state = 5;
                    return ;
            }
            super.leaveChild(nextState);
        }

    }

}
