//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v1.0 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2003.06.06 at 12:17:03 BST 
//


package edu.sdsc.matrix.srb.parser.impl;

public class DataGridRequestTypeImpl implements edu.sdsc.matrix.srb.parser.DataGridRequestType, com.sun.xml.bind.unmarshaller.UnmarshallableObject, com.sun.xml.bind.serializer.XMLSerializable, com.sun.xml.bind.validator.ValidatableObject
{

    protected edu.sdsc.matrix.srb.parser.FaultHandlers _FaultHandler;
    protected edu.sdsc.matrix.srb.parser.TransactionStatusQuery _TransactionStatusQuery;
    protected edu.sdsc.matrix.srb.parser.Transaction _Transaction;
    protected edu.sdsc.matrix.srb.parser.UserInfo _GridUser;
    protected edu.sdsc.matrix.srb.parser.VirtualOrganizationInfo _VOInfo;
    protected edu.sdsc.matrix.srb.parser.DocMeta _DocMeta;
    private final static com.sun.msv.grammar.Grammar schemaFragment = com.sun.xml.bind.validator.SchemaDeserializer.deserialize("\u00ac\u00ed\u0000\u0005sr\u0000\u001fcom.sun.msv.grammar.SequenceExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\u001dcom.sun.msv.grammar.BinaryExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\u0004exp1t\u0000 Lcom/sun/msv/grammar/Expression;L\u0000\u0004exp2q\u0000~\u0000\u0002xr\u0000\u001ecom.sun.msv.grammar.Expression\u00f8\u0018\u0082\u00e8N5~O\u0002\u0000\u0003I\u0000\u000ecachedHashCodeL\u0000\u0013epsilonReducibilityt\u0000\u0013Ljava/lang/Boolean;L\u0000\u000bexpandedExpq\u0000~\u0000\u0002xp\n\u00deQ0ppsq\u0000~\u0000\u0000\t\u000e\u0098\u00fcppsq\u0000~\u0000\u0000\u0005o(\u0097ppsq\u0000~\u0000\u0000\u0003\u009fpcppsr\u0000\'com.sun.msv.grammar.trex.ElementPattern\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000\tnameClasst\u0000\u001fLcom/sun/msv/grammar/NameClass;xr\u0000\u001ecom.sun.msv.grammar.ElementExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002Z\u0000\u001aignoreUndeclaredAttributesL\u0000\fcontentModelq\u0000~\u0000\u0002xq\u0000~\u0000\u0003\u0001\u00cf\u00b8/pp\u0000sq\u0000~\u0000\t\u0001\u00cf\u00b8$pp\u0000sr\u0000\u001dcom.sun.msv.grammar.ChoiceExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0001\u0001\u00cf\u00b8\u0019ppsr\u0000 com.sun.msv.grammar.OneOrMoreExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\u001ccom.sun.msv.grammar.UnaryExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000\u0003expq\u0000~\u0000\u0002xq\u0000~\u0000\u0003\u0001\u00cf\u00b8\u000esr\u0000\u0011java.lang.Boolean\u00cd r\u0080\u00d5\u009c\u00fa\u00ee\u0002\u0000\u0001Z\u0000\u0005valuexp\u0000psr\u0000 com.sun.msv.grammar.AttributeExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\u0003expq\u0000~\u0000\u0002L\u0000\tnameClassq\u0000~\u0000\nxq\u0000~\u0000\u0003\u0001\u00cf\u00b8\u000bq\u0000~\u0000\u0014psr\u00002com.sun.msv.grammar.Expression$AnyStringExpression\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0003\u0000\u0000\u0000\bsq\u0000~\u0000\u0013\u0001q\u0000~\u0000\u0018sr\u0000 com.sun.msv.grammar.AnyNameClass\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\u001dcom.sun.msv.grammar.NameClass\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xpsr\u00000com.sun.msv.grammar.Expression$EpsilonExpression\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0003\u0000\u0000\u0000\tq\u0000~\u0000\u0019psr\u0000#com.sun.msv.grammar.SimpleNameClass\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\tlocalNamet\u0000\u0012Ljava/lang/String;L\u0000\fnamespaceURIq\u0000~\u0000 xq\u0000~\u0000\u001bt\u0000\"edu.sdsc.matrix.srb.parser.DocMetat\u0000+http://java.sun.com/jaxb/xjc/dummy-elementssq\u0000~\u0000\u001ft\u0000\u0007DocMetat\u0000(http://www.teragrid.org/schemas/datagridsq\u0000~\u0000\t\u0001\u00cf\u00b8/pp\u0000sq\u0000~\u0000\t\u0001\u00cf\u00b8$pp\u0000sq\u0000~\u0000\u000e\u0001\u00cf\u00b8\u0019ppsq\u0000~\u0000\u0010\u0001\u00cf\u00b8\u000eq\u0000~\u0000\u0014psq\u0000~\u0000\u0015\u0001\u00cf\u00b8\u000bq\u0000~\u0000\u0014pq\u0000~\u0000\u0018q\u0000~\u0000\u001cq\u0000~\u0000\u001esq\u0000~\u0000\u001ft\u0000#edu.sdsc.matrix.srb.parser.UserInfoq\u0000~\u0000#sq\u0000~\u0000\u001ft\u0000\bGridUserq\u0000~\u0000&sq\u0000~\u0000\t\u0001\u00cf\u00b8/pp\u0000sq\u0000~\u0000\t\u0001\u00cf\u00b8$pp\u0000sq\u0000~\u0000\u000e\u0001\u00cf\u00b8\u0019ppsq\u0000~\u0000\u0010\u0001\u00cf\u00b8\u000eq\u0000~\u0000\u0014psq\u0000~\u0000\u0015\u0001\u00cf\u00b8\u000bq\u0000~\u0000\u0014pq\u0000~\u0000\u0018q\u0000~\u0000\u001cq\u0000~\u0000\u001esq\u0000~\u0000\u001ft\u00002edu.sdsc.matrix.srb.parser.VirtualOrganizationInfoq\u0000~\u0000#sq\u0000~\u0000\u001ft\u0000\u0006VOInfoq\u0000~\u0000&sq\u0000~\u0000\u000e\u0003\u009fp`ppsq\u0000~\u0000\t\u0001\u00cf\u00b8/pp\u0000sq\u0000~\u0000\t\u0001\u00cf\u00b8$pp\u0000sq\u0000~\u0000\u000e\u0001\u00cf\u00b8\u0019ppsq\u0000~\u0000\u0010\u0001\u00cf\u00b8\u000eq\u0000~\u0000\u0014psq\u0000~\u0000\u0015\u0001\u00cf\u00b8\u000bq\u0000~\u0000\u0014pq\u0000~\u0000\u0018q\u0000~\u0000\u001cq\u0000~\u0000\u001esq\u0000~\u0000\u001ft\u0000&edu.sdsc.matrix.srb.parser.Transactionq\u0000~\u0000#sq\u0000~\u0000\u001ft\u0000\u000bTransactionq\u0000~\u0000&sq\u0000~\u0000\t\u0001\u00cf\u00b8/pp\u0000sq\u0000~\u0000\t\u0001\u00cf\u00b8$pp\u0000sq\u0000~\u0000\u000e\u0001\u00cf\u00b8\u0019ppsq\u0000~\u0000\u0010\u0001\u00cf\u00b8\u000eq\u0000~\u0000\u0014psq\u0000~\u0000\u0015\u0001\u00cf\u00b8\u000bq\u0000~\u0000\u0014pq\u0000~\u0000\u0018q\u0000~\u0000\u001cq\u0000~\u0000\u001esq\u0000~\u0000\u001ft\u00001edu.sdsc.matrix.srb.parser.TransactionStatusQueryq\u0000~\u0000#sq\u0000~\u0000\u001ft\u0000\u0016TransactionStatusQueryq\u0000~\u0000&sq\u0000~\u0000\t\u0001\u00cf\u00b8/pp\u0000sq\u0000~\u0000\t\u0001\u00cf\u00b8$pp\u0000sq\u0000~\u0000\u000e\u0001\u00cf\u00b8\u0019ppsq\u0000~\u0000\u0010\u0001\u00cf\u00b8\u000eq\u0000~\u0000\u0014psq\u0000~\u0000\u0015\u0001\u00cf\u00b8\u000bq\u0000~\u0000\u0014pq\u0000~\u0000\u0018q\u0000~\u0000\u001cq\u0000~\u0000\u001esq\u0000~\u0000\u001ft\u0000(edu.sdsc.matrix.srb.parser.FaultHandlersq\u0000~\u0000#sq\u0000~\u0000\u001ft\u0000\fFaultHandlerq\u0000~\u0000&sr\u0000\"com.sun.msv.grammar.ExpressionPool\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000\bexpTablet\u0000/Lcom/sun/msv/grammar/ExpressionPool$ClosedHash;xpsr\u0000-com.sun.msv.grammar.ExpressionPool$ClosedHash\u00d7j\u00d0N\u00ef\u00e8\u00ed\u001c\u0002\u0000\u0004I\u0000\u0005countI\u0000\tthresholdL\u0000\u0006parentq\u0000~\u0000V[\u0000\u0005tablet\u0000![Lcom/sun/msv/grammar/Expression;xp\u0000\u0000\u0000\u0011\u0000\u0000\u00009pur\u0000![Lcom.sun.msv.grammar.Expression;\u00d68D\u00c3]\u00ad\u00a7\n\u0002\u0000\u0000xp\u0000\u0000\u0000\u00bfppppppppppppppppppppppppppppppppppq\u0000~\u0000\u0006ppppppppppppq\u0000~\u00009ppq\u0000~\u0000\bppppppppppppppppppppppppppppppppppq\u0000~\u0000\u0012q\u0000~\u0000*q\u0000~\u00003q\u0000~\u0000=q\u0000~\u0000Fq\u0000~\u0000Opppppq\u0000~\u0000\u000fq\u0000~\u0000)q\u0000~\u00002q\u0000~\u0000<q\u0000~\u0000Eq\u0000~\u0000Npppppppppppppppppppppppppppppppppppppppppppppppppppppppq\u0000~\u0000\u0005pppppppppppppppq\u0000~\u0000\u0007ppppppppppppppppp");

    private final static java.lang.Class PRIMARY_INTERFACE_CLASS() {
        return edu.sdsc.matrix.srb.parser.DataGridRequestType.class;
    }

    public edu.sdsc.matrix.srb.parser.FaultHandlers getFaultHandler() {
        return _FaultHandler;
    }

    public void setFaultHandler(edu.sdsc.matrix.srb.parser.FaultHandlers value) {
        _FaultHandler = value;
    }

    public edu.sdsc.matrix.srb.parser.TransactionStatusQuery getTransactionStatusQuery() {
        return _TransactionStatusQuery;
    }

    public void setTransactionStatusQuery(edu.sdsc.matrix.srb.parser.TransactionStatusQuery value) {
        _TransactionStatusQuery = value;
    }

    public edu.sdsc.matrix.srb.parser.Transaction getTransaction() {
        return _Transaction;
    }

    public void setTransaction(edu.sdsc.matrix.srb.parser.Transaction value) {
        _Transaction = value;
    }

    public edu.sdsc.matrix.srb.parser.UserInfo getGridUser() {
        return _GridUser;
    }

    public void setGridUser(edu.sdsc.matrix.srb.parser.UserInfo value) {
        _GridUser = value;
    }

    public edu.sdsc.matrix.srb.parser.VirtualOrganizationInfo getVOInfo() {
        return _VOInfo;
    }

    public void setVOInfo(edu.sdsc.matrix.srb.parser.VirtualOrganizationInfo value) {
        _VOInfo = value;
    }

    public edu.sdsc.matrix.srb.parser.DocMeta getDocMeta() {
        return _DocMeta;
    }

    public void setDocMeta(edu.sdsc.matrix.srb.parser.DocMeta value) {
        _DocMeta = value;
    }

    public com.sun.xml.bind.unmarshaller.ContentHandlerEx getUnmarshaller(com.sun.xml.bind.unmarshaller.UnmarshallingContext context) {
        return new edu.sdsc.matrix.srb.parser.impl.DataGridRequestTypeImpl.Unmarshaller(context);
    }

    public java.lang.Class getPrimaryInterfaceClass() {
        return PRIMARY_INTERFACE_CLASS();
    }

    public void serializeElements(com.sun.xml.bind.serializer.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
        if (_DocMeta instanceof javax.xml.bind.Element) {
            context.childAsElements(((com.sun.xml.bind.serializer.XMLSerializable) _DocMeta));
        } else {
            context.startElement("http://www.teragrid.org/schemas/datagrid", "DocMeta");
            context.childAsAttributes(((com.sun.xml.bind.serializer.XMLSerializable) _DocMeta));
            context.endAttributes();
            context.childAsElements(((com.sun.xml.bind.serializer.XMLSerializable) _DocMeta));
            context.endElement();
        }
        if (_GridUser instanceof javax.xml.bind.Element) {
            context.childAsElements(((com.sun.xml.bind.serializer.XMLSerializable) _GridUser));
        } else {
            context.startElement("http://www.teragrid.org/schemas/datagrid", "GridUser");
            context.childAsAttributes(((com.sun.xml.bind.serializer.XMLSerializable) _GridUser));
            context.endAttributes();
            context.childAsElements(((com.sun.xml.bind.serializer.XMLSerializable) _GridUser));
            context.endElement();
        }
        if (_VOInfo instanceof javax.xml.bind.Element) {
            context.childAsElements(((com.sun.xml.bind.serializer.XMLSerializable) _VOInfo));
        } else {
            context.startElement("http://www.teragrid.org/schemas/datagrid", "VOInfo");
            context.childAsAttributes(((com.sun.xml.bind.serializer.XMLSerializable) _VOInfo));
            context.endAttributes();
            context.childAsElements(((com.sun.xml.bind.serializer.XMLSerializable) _VOInfo));
            context.endElement();
        }
        if ((_Transaction!= null)&&(_TransactionStatusQuery == null)) {
            if (_Transaction instanceof javax.xml.bind.Element) {
                context.childAsElements(((com.sun.xml.bind.serializer.XMLSerializable) _Transaction));
            } else {
                context.startElement("http://www.teragrid.org/schemas/datagrid", "Transaction");
                context.childAsAttributes(((com.sun.xml.bind.serializer.XMLSerializable) _Transaction));
                context.endAttributes();
                context.childAsElements(((com.sun.xml.bind.serializer.XMLSerializable) _Transaction));
                context.endElement();
            }
        } else {
            if ((_Transaction == null)&&(_TransactionStatusQuery!= null)) {
                if (_TransactionStatusQuery instanceof javax.xml.bind.Element) {
                    context.childAsElements(((com.sun.xml.bind.serializer.XMLSerializable) _TransactionStatusQuery));
                } else {
                    context.startElement("http://www.teragrid.org/schemas/datagrid", "TransactionStatusQuery");
                    context.childAsAttributes(((com.sun.xml.bind.serializer.XMLSerializable) _TransactionStatusQuery));
                    context.endAttributes();
                    context.childAsElements(((com.sun.xml.bind.serializer.XMLSerializable) _TransactionStatusQuery));
                    context.endElement();
                }
            }
        }
        if (_FaultHandler instanceof javax.xml.bind.Element) {
            context.childAsElements(((com.sun.xml.bind.serializer.XMLSerializable) _FaultHandler));
        } else {
            context.startElement("http://www.teragrid.org/schemas/datagrid", "FaultHandler");
            context.childAsAttributes(((com.sun.xml.bind.serializer.XMLSerializable) _FaultHandler));
            context.endAttributes();
            context.childAsElements(((com.sun.xml.bind.serializer.XMLSerializable) _FaultHandler));
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
        return (edu.sdsc.matrix.srb.parser.DataGridRequestType.class);
    }

    public com.sun.msv.verifier.DocumentDeclaration createRawValidator() {
        return new com.sun.msv.verifier.regexp.REDocumentDeclaration(schemaFragment);
    }

    public class Unmarshaller
        extends com.sun.xml.bind.unmarshaller.ContentHandlerEx
    {


        public Unmarshaller(com.sun.xml.bind.unmarshaller.UnmarshallingContext context) {
            super(context, "------------------");
        }

        protected com.sun.xml.bind.unmarshaller.UnmarshallableObject owner() {
            return edu.sdsc.matrix.srb.parser.impl.DataGridRequestTypeImpl.this;
        }

        public void enterElement(java.lang.String ___uri, java.lang.String ___local, org.xml.sax.Attributes __atts)
            throws com.sun.xml.bind.unmarshaller.UnreportedException
        {
            switch (state) {
                case  13 :
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("TBA" == ___local)) {
                        _FaultHandler = ((edu.sdsc.matrix.srb.parser.impl.FaultHandlersImpl) spawnChildFromEnterElement((edu.sdsc.matrix.srb.parser.impl.FaultHandlersImpl.class), 14, ___uri, ___local, __atts));
                        return ;
                    }
                    break;
                case  4 :
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("gridTicket" == ___local)) {
                        _GridUser = ((edu.sdsc.matrix.srb.parser.impl.UserInfoImpl) spawnChildFromEnterElement((edu.sdsc.matrix.srb.parser.impl.UserInfoImpl.class), 5, ___uri, ___local, __atts));
                        return ;
                    }
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("userID" == ___local)) {
                        _GridUser = ((edu.sdsc.matrix.srb.parser.impl.UserInfoImpl) spawnChildFromEnterElement((edu.sdsc.matrix.srb.parser.impl.UserInfoImpl.class), 5, ___uri, ___local, __atts));
                        return ;
                    }
                    break;
                case  10 :
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("Flow" == ___local)) {
                        _Transaction = ((edu.sdsc.matrix.srb.parser.impl.TransactionImpl) spawnChildFromEnterElement((edu.sdsc.matrix.srb.parser.impl.TransactionImpl.class), 11, ___uri, ___local, __atts));
                        return ;
                    }
                    break;
                case  16 :
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("FlowStatusQuery" == ___local)) {
                        _TransactionStatusQuery = ((edu.sdsc.matrix.srb.parser.impl.TransactionStatusQueryImpl) spawnChildFromEnterElement((edu.sdsc.matrix.srb.parser.impl.TransactionStatusQueryImpl.class), 17, ___uri, ___local, __atts));
                        return ;
                    }
                    break;
                case  7 :
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("server" == ___local)) {
                        _VOInfo = ((edu.sdsc.matrix.srb.parser.impl.VirtualOrganizationInfoImpl) spawnChildFromEnterElement((edu.sdsc.matrix.srb.parser.impl.VirtualOrganizationInfoImpl.class), 8, ___uri, ___local, __atts));
                        return ;
                    }
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("voID" == ___local)) {
                        _VOInfo = ((edu.sdsc.matrix.srb.parser.impl.VirtualOrganizationInfoImpl) spawnChildFromEnterElement((edu.sdsc.matrix.srb.parser.impl.VirtualOrganizationInfoImpl.class), 8, ___uri, ___local, __atts));
                        return ;
                    }
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("description" == ___local)) {
                        _VOInfo = ((edu.sdsc.matrix.srb.parser.impl.VirtualOrganizationInfoImpl) spawnChildFromEnterElement((edu.sdsc.matrix.srb.parser.impl.VirtualOrganizationInfoImpl.class), 8, ___uri, ___local, __atts));
                        return ;
                    }
                    break;
                case  9 :
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("Transaction" == ___local)) {
                        context.pushAttributes(__atts);
                        state = 10;
                        return ;
                    }
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("TransactionStatusQuery" == ___local)) {
                        context.pushAttributes(__atts);
                        goto16();
                        return ;
                    }
                    break;
                case  6 :
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("VOInfo" == ___local)) {
                        context.pushAttributes(__atts);
                        state = 7;
                        return ;
                    }
                    break;
                case  15 :
                    revertToParentFromEnterElement(___uri, ___local, __atts);
                    return ;
                case  0 :
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("DocMeta" == ___local)) {
                        context.pushAttributes(__atts);
                        state = 1;
                        return ;
                    }
                    break;
                case  1 :
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("docAuthor" == ___local)) {
                        _DocMeta = ((edu.sdsc.matrix.srb.parser.impl.DocMetaImpl) spawnChildFromEnterElement((edu.sdsc.matrix.srb.parser.impl.DocMetaImpl.class), 2, ___uri, ___local, __atts));
                        return ;
                    }
                    break;
                case  12 :
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("FaultHandler" == ___local)) {
                        context.pushAttributes(__atts);
                        goto13();
                        return ;
                    }
                    break;
                case  3 :
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("GridUser" == ___local)) {
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
                case  11 :
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("Transaction" == ___local)) {
                        context.popAttributes();
                        state = 12;
                        return ;
                    }
                    break;
                case  5 :
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("GridUser" == ___local)) {
                        context.popAttributes();
                        state = 6;
                        return ;
                    }
                    break;
                case  8 :
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("VOInfo" == ___local)) {
                        context.popAttributes();
                        state = 9;
                        return ;
                    }
                    break;
                case  7 :
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("VOInfo" == ___local)) {
                        _VOInfo = ((edu.sdsc.matrix.srb.parser.impl.VirtualOrganizationInfoImpl) spawnChildFromLeaveElement((edu.sdsc.matrix.srb.parser.impl.VirtualOrganizationInfoImpl.class), 8, ___uri, ___local));
                        return ;
                    }
                    break;
                case  14 :
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("FaultHandler" == ___local)) {
                        context.popAttributes();
                        state = 15;
                        return ;
                    }
                    break;
                case  2 :
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("DocMeta" == ___local)) {
                        context.popAttributes();
                        state = 3;
                        return ;
                    }
                    break;
                case  15 :
                    revertToParentFromLeaveElement(___uri, ___local);
                    return ;
                case  17 :
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("TransactionStatusQuery" == ___local)) {
                        context.popAttributes();
                        state = 12;
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
                case  13 :
                    if (("" == ___uri)&&("name" == ___local)) {
                        _FaultHandler = ((edu.sdsc.matrix.srb.parser.impl.FaultHandlersImpl) spawnChildFromEnterAttribute((edu.sdsc.matrix.srb.parser.impl.FaultHandlersImpl.class), 14, ___uri, ___local));
                        return ;
                    }
                    break;
                case  16 :
                    if (("" == ___uri)&&("transactionID" == ___local)) {
                        _TransactionStatusQuery = ((edu.sdsc.matrix.srb.parser.impl.TransactionStatusQueryImpl) spawnChildFromEnterAttribute((edu.sdsc.matrix.srb.parser.impl.TransactionStatusQueryImpl.class), 17, ___uri, ___local));
                        return ;
                    }
                    break;
                case  15 :
                    revertToParentFromEnterAttribute(___uri, ___local);
                    return ;
            }
            super.enterAttribute(___uri, ___local);
        }

        public void leaveAttribute(java.lang.String ___uri, java.lang.String ___local)
            throws com.sun.xml.bind.unmarshaller.UnreportedException
        {
            switch (state) {
                case  15 :
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
                    case  15 :
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
                case  14 :
                    state = 14;
                    return ;
                case  2 :
                    state = 2;
                    return ;
                case  11 :
                    state = 11;
                    return ;
                case  8 :
                    state = 8;
                    return ;
                case  5 :
                    state = 5;
                    return ;
                case  17 :
                    state = 17;
                    return ;
            }
            super.leaveChild(nextState);
        }

        private void goto13()
            throws com.sun.xml.bind.unmarshaller.UnreportedException
        {
            int idx;
            state = 13;
            idx = context.getAttribute("", "name");
            if (idx >= 0) {
                context.consumeAttribute(idx);
                return ;
            }
        }

        private void goto16()
            throws com.sun.xml.bind.unmarshaller.UnreportedException
        {
            int idx;
            state = 16;
            idx = context.getAttribute("", "transactionID");
            if (idx >= 0) {
                context.consumeAttribute(idx);
                return ;
            }
        }

    }

}
