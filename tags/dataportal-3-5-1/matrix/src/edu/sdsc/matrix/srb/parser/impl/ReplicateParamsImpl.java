//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v1.0 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2003.06.06 at 12:17:03 BST 
//


package edu.sdsc.matrix.srb.parser.impl;

public class ReplicateParamsImpl implements edu.sdsc.matrix.srb.parser.ReplicateParams, com.sun.xml.bind.unmarshaller.UnmarshallableObject, com.sun.xml.bind.serializer.XMLSerializable, com.sun.xml.bind.validator.ValidatableObject
{

    protected edu.sdsc.matrix.srb.parser.StdDatagridObject _DataSource;
    protected edu.sdsc.matrix.srb.parser.ReplicateParams.DataTargetType _DataTarget;
    private final static com.sun.msv.grammar.Grammar schemaFragment = com.sun.xml.bind.validator.SchemaDeserializer.deserialize("\u00ac\u00ed\u0000\u0005sr\u0000\u001fcom.sun.msv.grammar.SequenceExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\u001dcom.sun.msv.grammar.BinaryExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\u0004exp1t\u0000 Lcom/sun/msv/grammar/Expression;L\u0000\u0004exp2q\u0000~\u0000\u0002xr\u0000\u001ecom.sun.msv.grammar.Expression\u00f8\u0018\u0082\u00e8N5~O\u0002\u0000\u0003I\u0000\u000ecachedHashCodeL\u0000\u0013epsilonReducibilityt\u0000\u0013Ljava/lang/Boolean;L\u0000\u000bexpandedExpq\u0000~\u0000\u0002xp\u0003\u009fpnppsr\u0000\'com.sun.msv.grammar.trex.ElementPattern\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000\tnameClasst\u0000\u001fLcom/sun/msv/grammar/NameClass;xr\u0000\u001ecom.sun.msv.grammar.ElementExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002Z\u0000\u001aignoreUndeclaredAttributesL\u0000\fcontentModelq\u0000~\u0000\u0002xq\u0000~\u0000\u0003\u0001\u00cf\u00b8/pp\u0000sq\u0000~\u0000\u0006\u0001\u00cf\u00b8$pp\u0000sr\u0000\u001dcom.sun.msv.grammar.ChoiceExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0001\u0001\u00cf\u00b8\u0019ppsr\u0000 com.sun.msv.grammar.OneOrMoreExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\u001ccom.sun.msv.grammar.UnaryExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000\u0003expq\u0000~\u0000\u0002xq\u0000~\u0000\u0003\u0001\u00cf\u00b8\u000esr\u0000\u0011java.lang.Boolean\u00cd r\u0080\u00d5\u009c\u00fa\u00ee\u0002\u0000\u0001Z\u0000\u0005valuexp\u0000psr\u0000 com.sun.msv.grammar.AttributeExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\u0003expq\u0000~\u0000\u0002L\u0000\tnameClassq\u0000~\u0000\u0007xq\u0000~\u0000\u0003\u0001\u00cf\u00b8\u000bq\u0000~\u0000\u0011psr\u00002com.sun.msv.grammar.Expression$AnyStringExpression\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0003\u0000\u0000\u0000\bsq\u0000~\u0000\u0010\u0001q\u0000~\u0000\u0015sr\u0000 com.sun.msv.grammar.AnyNameClass\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\u001dcom.sun.msv.grammar.NameClass\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xpsr\u00000com.sun.msv.grammar.Expression$EpsilonExpression\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0003\u0000\u0000\u0000\tq\u0000~\u0000\u0016psr\u0000#com.sun.msv.grammar.SimpleNameClass\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\tlocalNamet\u0000\u0012Ljava/lang/String;L\u0000\fnamespaceURIq\u0000~\u0000\u001dxq\u0000~\u0000\u0018t\u0000,edu.sdsc.matrix.srb.parser.StdDatagridObjectt\u0000+http://java.sun.com/jaxb/xjc/dummy-elementssq\u0000~\u0000\u001ct\u0000\nDataSourcet\u0000(http://www.teragrid.org/schemas/datagridsq\u0000~\u0000\u000b\u0001\u00cf\u00b8:ppsq\u0000~\u0000\u0006\u0001\u00cf\u00b8/q\u0000~\u0000\u0011p\u0000sq\u0000~\u0000\u0006\u0001\u00cf\u00b8$pp\u0000sq\u0000~\u0000\u000b\u0001\u00cf\u00b8\u0019ppsq\u0000~\u0000\r\u0001\u00cf\u00b8\u000eq\u0000~\u0000\u0011psq\u0000~\u0000\u0012\u0001\u00cf\u00b8\u000bq\u0000~\u0000\u0011pq\u0000~\u0000\u0015q\u0000~\u0000\u0019q\u0000~\u0000\u001bsq\u0000~\u0000\u001ct\u00009edu.sdsc.matrix.srb.parser.ReplicateParams.DataTargetTypeq\u0000~\u0000 sq\u0000~\u0000\u001ct\u0000\nDataTargetq\u0000~\u0000#q\u0000~\u0000\u001bsr\u0000\"com.sun.msv.grammar.ExpressionPool\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000\bexpTablet\u0000/Lcom/sun/msv/grammar/ExpressionPool$ClosedHash;xpsr\u0000-com.sun.msv.grammar.ExpressionPool$ClosedHash\u00d7j\u00d0N\u00ef\u00e8\u00ed\u001c\u0002\u0000\u0004I\u0000\u0005countI\u0000\tthresholdL\u0000\u0006parentq\u0000~\u0000/[\u0000\u0005tablet\u0000![Lcom/sun/msv/grammar/Expression;xp\u0000\u0000\u0000\u0006\u0000\u0000\u00009pur\u0000![Lcom.sun.msv.grammar.Expression;\u00d68D\u00c3]\u00ad\u00a7\n\u0002\u0000\u0000xp\u0000\u0000\u0000\u00bfpppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppq\u0000~\u0000\u0005pppppppppppppppppppppppq\u0000~\u0000\u000fq\u0000~\u0000(pppppppppq\u0000~\u0000\fq\u0000~\u0000\'pppppppppppppppppppppppppppppppq\u0000~\u0000$ppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppp");

    private final static java.lang.Class PRIMARY_INTERFACE_CLASS() {
        return edu.sdsc.matrix.srb.parser.ReplicateParams.class;
    }

    public edu.sdsc.matrix.srb.parser.StdDatagridObject getDataSource() {
        return _DataSource;
    }

    public void setDataSource(edu.sdsc.matrix.srb.parser.StdDatagridObject value) {
        _DataSource = value;
    }

    public edu.sdsc.matrix.srb.parser.ReplicateParams.DataTargetType getDataTarget() {
        return _DataTarget;
    }

    public void setDataTarget(edu.sdsc.matrix.srb.parser.ReplicateParams.DataTargetType value) {
        _DataTarget = value;
    }

    public com.sun.xml.bind.unmarshaller.ContentHandlerEx getUnmarshaller(com.sun.xml.bind.unmarshaller.UnmarshallingContext context) {
        return new edu.sdsc.matrix.srb.parser.impl.ReplicateParamsImpl.Unmarshaller(context);
    }

    public java.lang.Class getPrimaryInterfaceClass() {
        return PRIMARY_INTERFACE_CLASS();
    }

    public void serializeElements(com.sun.xml.bind.serializer.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
        if (_DataSource instanceof javax.xml.bind.Element) {
            context.childAsElements(((com.sun.xml.bind.serializer.XMLSerializable) _DataSource));
        } else {
            context.startElement("http://www.teragrid.org/schemas/datagrid", "DataSource");
            context.childAsAttributes(((com.sun.xml.bind.serializer.XMLSerializable) _DataSource));
            context.endAttributes();
            context.childAsElements(((com.sun.xml.bind.serializer.XMLSerializable) _DataSource));
            context.endElement();
        }
        if (_DataTarget!= null) {
            if (_DataTarget instanceof javax.xml.bind.Element) {
                context.childAsElements(((com.sun.xml.bind.serializer.XMLSerializable) _DataTarget));
            } else {
                context.startElement("http://www.teragrid.org/schemas/datagrid", "DataTarget");
                context.childAsAttributes(((com.sun.xml.bind.serializer.XMLSerializable) _DataTarget));
                context.endAttributes();
                context.childAsElements(((com.sun.xml.bind.serializer.XMLSerializable) _DataTarget));
                context.endElement();
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
        return (edu.sdsc.matrix.srb.parser.ReplicateParams.class);
    }

    public com.sun.msv.verifier.DocumentDeclaration createRawValidator() {
        return new com.sun.msv.verifier.regexp.REDocumentDeclaration(schemaFragment);
    }

    public static class DataTargetTypeImpl implements edu.sdsc.matrix.srb.parser.ReplicateParams.DataTargetType, com.sun.xml.bind.unmarshaller.UnmarshallableObject, com.sun.xml.bind.serializer.XMLSerializable, com.sun.xml.bind.validator.ValidatableObject
    {

        protected edu.sdsc.matrix.srb.parser.Collection _TargetCollection;
        protected edu.sdsc.matrix.srb.parser.Resource _TargetResource;
        private final static com.sun.msv.grammar.Grammar schemaFragment = com.sun.xml.bind.validator.SchemaDeserializer.deserialize("\u00ac\u00ed\u0000\u0005sr\u0000\u001fcom.sun.msv.grammar.SequenceExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\u001dcom.sun.msv.grammar.BinaryExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\u0004exp1t\u0000 Lcom/sun/msv/grammar/Expression;L\u0000\u0004exp2q\u0000~\u0000\u0002xr\u0000\u001ecom.sun.msv.grammar.Expression\u00f8\u0018\u0082\u00e8N5~O\u0002\u0000\u0003I\u0000\u000ecachedHashCodeL\u0000\u0013epsilonReducibilityt\u0000\u0013Ljava/lang/Boolean;L\u0000\u000bexpandedExpq\u0000~\u0000\u0002xp\u0003\u009fpyppsr\u0000\u001dcom.sun.msv.grammar.ChoiceExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0001\u0001\u00cf\u00b8:ppsr\u0000\'com.sun.msv.grammar.trex.ElementPattern\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000\tnameClasst\u0000\u001fLcom/sun/msv/grammar/NameClass;xr\u0000\u001ecom.sun.msv.grammar.ElementExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002Z\u0000\u001aignoreUndeclaredAttributesL\u0000\fcontentModelq\u0000~\u0000\u0002xq\u0000~\u0000\u0003\u0001\u00cf\u00b8/sr\u0000\u0011java.lang.Boolean\u00cd r\u0080\u00d5\u009c\u00fa\u00ee\u0002\u0000\u0001Z\u0000\u0005valuexp\u0000p\u0000sq\u0000~\u0000\b\u0001\u00cf\u00b8$pp\u0000sq\u0000~\u0000\u0006\u0001\u00cf\u00b8\u0019ppsr\u0000 com.sun.msv.grammar.OneOrMoreExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\u001ccom.sun.msv.grammar.UnaryExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000\u0003expq\u0000~\u0000\u0002xq\u0000~\u0000\u0003\u0001\u00cf\u00b8\u000eq\u0000~\u0000\rpsr\u0000 com.sun.msv.grammar.AttributeExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\u0003expq\u0000~\u0000\u0002L\u0000\tnameClassq\u0000~\u0000\txq\u0000~\u0000\u0003\u0001\u00cf\u00b8\u000bq\u0000~\u0000\rpsr\u00002com.sun.msv.grammar.Expression$AnyStringExpression\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0003\u0000\u0000\u0000\bsq\u0000~\u0000\f\u0001q\u0000~\u0000\u0016sr\u0000 com.sun.msv.grammar.AnyNameClass\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\u001dcom.sun.msv.grammar.NameClass\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xpsr\u00000com.sun.msv.grammar.Expression$EpsilonExpression\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0003\u0000\u0000\u0000\tq\u0000~\u0000\u0017psr\u0000#com.sun.msv.grammar.SimpleNameClass\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\tlocalNamet\u0000\u0012Ljava/lang/String;L\u0000\fnamespaceURIq\u0000~\u0000\u001exq\u0000~\u0000\u0019t\u0000%edu.sdsc.matrix.srb.parser.Collectiont\u0000+http://java.sun.com/jaxb/xjc/dummy-elementssq\u0000~\u0000\u001dt\u0000\u0010TargetCollectiont\u0000(http://www.teragrid.org/schemas/datagridq\u0000~\u0000\u001csq\u0000~\u0000\u0006\u0001\u00cf\u00b8:ppsq\u0000~\u0000\b\u0001\u00cf\u00b8/q\u0000~\u0000\rp\u0000sq\u0000~\u0000\b\u0001\u00cf\u00b8$pp\u0000sq\u0000~\u0000\u0006\u0001\u00cf\u00b8\u0019ppsq\u0000~\u0000\u0010\u0001\u00cf\u00b8\u000eq\u0000~\u0000\rpsq\u0000~\u0000\u0013\u0001\u00cf\u00b8\u000bq\u0000~\u0000\rpq\u0000~\u0000\u0016q\u0000~\u0000\u001aq\u0000~\u0000\u001csq\u0000~\u0000\u001dt\u0000#edu.sdsc.matrix.srb.parser.Resourceq\u0000~\u0000!sq\u0000~\u0000\u001dt\u0000\u000eTargetResourceq\u0000~\u0000$q\u0000~\u0000\u001csr\u0000\"com.sun.msv.grammar.ExpressionPool\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000\bexpTablet\u0000/Lcom/sun/msv/grammar/ExpressionPool$ClosedHash;xpsr\u0000-com.sun.msv.grammar.ExpressionPool$ClosedHash\u00d7j\u00d0N\u00ef\u00e8\u00ed\u001c\u0002\u0000\u0004I\u0000\u0005countI\u0000\tthresholdL\u0000\u0006parentq\u0000~\u00000[\u0000\u0005tablet\u0000![Lcom/sun/msv/grammar/Expression;xp\u0000\u0000\u0000\u0007\u0000\u0000\u00009pur\u0000![Lcom.sun.msv.grammar.Expression;\u00d68D\u00c3]\u00ad\u00a7\n\u0002\u0000\u0000xp\u0000\u0000\u0000\u00bfppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppq\u0000~\u0000\u0005ppppppppppppq\u0000~\u0000\u0012q\u0000~\u0000)pppppppppq\u0000~\u0000\u000fq\u0000~\u0000(pppppppppppppppppppppppppppppppq\u0000~\u0000\u0007q\u0000~\u0000%pppppppppppppppppppppppppppppppppppppppppppppppppppppppppppp");

        private final static java.lang.Class PRIMARY_INTERFACE_CLASS() {
            return edu.sdsc.matrix.srb.parser.ReplicateParams.DataTargetType.class;
        }

        public edu.sdsc.matrix.srb.parser.Collection getTargetCollection() {
            return _TargetCollection;
        }

        public void setTargetCollection(edu.sdsc.matrix.srb.parser.Collection value) {
            _TargetCollection = value;
        }

        public edu.sdsc.matrix.srb.parser.Resource getTargetResource() {
            return _TargetResource;
        }

        public void setTargetResource(edu.sdsc.matrix.srb.parser.Resource value) {
            _TargetResource = value;
        }

        public com.sun.xml.bind.unmarshaller.ContentHandlerEx getUnmarshaller(com.sun.xml.bind.unmarshaller.UnmarshallingContext context) {
            return new edu.sdsc.matrix.srb.parser.impl.ReplicateParamsImpl.DataTargetTypeImpl.Unmarshaller(context);
        }

        public java.lang.Class getPrimaryInterfaceClass() {
            return PRIMARY_INTERFACE_CLASS();
        }

        public void serializeElements(com.sun.xml.bind.serializer.XMLSerializer context)
            throws org.xml.sax.SAXException
        {
            if (_TargetCollection!= null) {
                if (_TargetCollection instanceof javax.xml.bind.Element) {
                    context.childAsElements(((com.sun.xml.bind.serializer.XMLSerializable) _TargetCollection));
                } else {
                    context.startElement("http://www.teragrid.org/schemas/datagrid", "TargetCollection");
                    context.childAsAttributes(((com.sun.xml.bind.serializer.XMLSerializable) _TargetCollection));
                    context.endAttributes();
                    context.childAsElements(((com.sun.xml.bind.serializer.XMLSerializable) _TargetCollection));
                    context.endElement();
                }
            }
            if (_TargetResource!= null) {
                if (_TargetResource instanceof javax.xml.bind.Element) {
                    context.childAsElements(((com.sun.xml.bind.serializer.XMLSerializable) _TargetResource));
                } else {
                    context.startElement("http://www.teragrid.org/schemas/datagrid", "TargetResource");
                    context.childAsAttributes(((com.sun.xml.bind.serializer.XMLSerializable) _TargetResource));
                    context.endAttributes();
                    context.childAsElements(((com.sun.xml.bind.serializer.XMLSerializable) _TargetResource));
                    context.endElement();
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
            return (edu.sdsc.matrix.srb.parser.ReplicateParams.DataTargetType.class);
        }

        public com.sun.msv.verifier.DocumentDeclaration createRawValidator() {
            return new com.sun.msv.verifier.regexp.REDocumentDeclaration(schemaFragment);
        }

        public class Unmarshaller
            extends com.sun.xml.bind.unmarshaller.ContentHandlerEx
        {


            public Unmarshaller(com.sun.xml.bind.unmarshaller.UnmarshallingContext context) {
                super(context, "-----");
            }

            protected com.sun.xml.bind.unmarshaller.UnmarshallableObject owner() {
                return edu.sdsc.matrix.srb.parser.impl.ReplicateParamsImpl.DataTargetTypeImpl.this;
            }

            public void enterElement(java.lang.String ___uri, java.lang.String ___local, org.xml.sax.Attributes __atts)
                throws com.sun.xml.bind.unmarshaller.UnreportedException
            {
                switch (state) {
                    case  0 :
                        if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("TargetResource" == ___local)) {
                            context.pushAttributes(__atts);
                            state = 3;
                            return ;
                        }
                        if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("TargetCollection" == ___local)) {
                            context.pushAttributes(__atts);
                            state = 1;
                            return ;
                        }
                        revertToParentFromEnterElement(___uri, ___local, __atts);
                        return ;
                    case  3 :
                        if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("logicalName" == ___local)) {
                            _TargetResource = ((edu.sdsc.matrix.srb.parser.impl.ResourceImpl) spawnChildFromEnterElement((edu.sdsc.matrix.srb.parser.impl.ResourceImpl.class), 4, ___uri, ___local, __atts));
                            return ;
                        }
                        break;
                    case  1 :
                        if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("AnyDirectory" == ___local)) {
                            _TargetCollection = ((edu.sdsc.matrix.srb.parser.impl.CollectionImpl) spawnChildFromEnterElement((edu.sdsc.matrix.srb.parser.impl.CollectionImpl.class), 2, ___uri, ___local, __atts));
                            return ;
                        }
                        if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("StdCollection" == ___local)) {
                            _TargetCollection = ((edu.sdsc.matrix.srb.parser.impl.CollectionImpl) spawnChildFromEnterElement((edu.sdsc.matrix.srb.parser.impl.CollectionImpl.class), 2, ___uri, ___local, __atts));
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
                    case  2 :
                        if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("TargetCollection" == ___local)) {
                            context.popAttributes();
                            state = 0;
                            return ;
                        }
                        break;
                    case  0 :
                        revertToParentFromLeaveElement(___uri, ___local);
                        return ;
                    case  4 :
                        if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("TargetResource" == ___local)) {
                            context.popAttributes();
                            state = 0;
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
                    case  0 :
                        revertToParentFromEnterAttribute(___uri, ___local);
                        return ;
                }
                super.enterAttribute(___uri, ___local);
            }

            public void leaveAttribute(java.lang.String ___uri, java.lang.String ___local)
                throws com.sun.xml.bind.unmarshaller.UnreportedException
            {
                switch (state) {
                    case  0 :
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
                        case  0 :
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
                    case  4 :
                        state = 4;
                        return ;
                }
                super.leaveChild(nextState);
            }

        }

    }

    public class Unmarshaller
        extends com.sun.xml.bind.unmarshaller.ContentHandlerEx
    {


        public Unmarshaller(com.sun.xml.bind.unmarshaller.UnmarshallingContext context) {
            super(context, "------");
        }

        protected com.sun.xml.bind.unmarshaller.UnmarshallableObject owner() {
            return edu.sdsc.matrix.srb.parser.impl.ReplicateParamsImpl.this;
        }

        public void enterElement(java.lang.String ___uri, java.lang.String ___local, org.xml.sax.Attributes __atts)
            throws com.sun.xml.bind.unmarshaller.UnreportedException
        {
            switch (state) {
                case  1 :
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("DataSetNow" == ___local)) {
                        _DataSource = ((edu.sdsc.matrix.srb.parser.impl.StdDatagridObjectImpl) spawnChildFromEnterElement((edu.sdsc.matrix.srb.parser.impl.StdDatagridObjectImpl.class), 2, ___uri, ___local, __atts));
                        return ;
                    }
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("CollectionNow" == ___local)) {
                        _DataSource = ((edu.sdsc.matrix.srb.parser.impl.StdDatagridObjectImpl) spawnChildFromEnterElement((edu.sdsc.matrix.srb.parser.impl.StdDatagridObjectImpl.class), 2, ___uri, ___local, __atts));
                        return ;
                    }
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("ADCnow" == ___local)) {
                        _DataSource = ((edu.sdsc.matrix.srb.parser.impl.StdDatagridObjectImpl) spawnChildFromEnterElement((edu.sdsc.matrix.srb.parser.impl.StdDatagridObjectImpl.class), 2, ___uri, ___local, __atts));
                        return ;
                    }
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("ActiveDataSetNow" == ___local)) {
                        _DataSource = ((edu.sdsc.matrix.srb.parser.impl.StdDatagridObjectImpl) spawnChildFromEnterElement((edu.sdsc.matrix.srb.parser.impl.StdDatagridObjectImpl.class), 2, ___uri, ___local, __atts));
                        return ;
                    }
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("ContainerNow" == ___local)) {
                        _DataSource = ((edu.sdsc.matrix.srb.parser.impl.StdDatagridObjectImpl) spawnChildFromEnterElement((edu.sdsc.matrix.srb.parser.impl.StdDatagridObjectImpl.class), 2, ___uri, ___local, __atts));
                        return ;
                    }
                    break;
                case  4 :
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("TargetResource" == ___local)) {
                        _DataTarget = ((edu.sdsc.matrix.srb.parser.impl.ReplicateParamsImpl.DataTargetTypeImpl) spawnChildFromEnterElement((edu.sdsc.matrix.srb.parser.impl.ReplicateParamsImpl.DataTargetTypeImpl.class), 5, ___uri, ___local, __atts));
                        return ;
                    }
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("TargetCollection" == ___local)) {
                        _DataTarget = ((edu.sdsc.matrix.srb.parser.impl.ReplicateParamsImpl.DataTargetTypeImpl) spawnChildFromEnterElement((edu.sdsc.matrix.srb.parser.impl.ReplicateParamsImpl.DataTargetTypeImpl.class), 5, ___uri, ___local, __atts));
                        return ;
                    }
                    break;
                case  0 :
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("DataSource" == ___local)) {
                        context.pushAttributes(__atts);
                        state = 1;
                        return ;
                    }
                    break;
                case  3 :
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("DataTarget" == ___local)) {
                        context.pushAttributes(__atts);
                        state = 4;
                        return ;
                    }
                    revertToParentFromEnterElement(___uri, ___local, __atts);
                    return ;
            }
            super.enterElement(___uri, ___local, __atts);
        }

        public void leaveElement(java.lang.String ___uri, java.lang.String ___local)
            throws com.sun.xml.bind.unmarshaller.UnreportedException
        {
            switch (state) {
                case  5 :
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("DataTarget" == ___local)) {
                        context.popAttributes();
                        state = 3;
                        return ;
                    }
                    break;
                case  4 :
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("DataTarget" == ___local)) {
                        _DataTarget = ((edu.sdsc.matrix.srb.parser.impl.ReplicateParamsImpl.DataTargetTypeImpl) spawnChildFromLeaveElement((edu.sdsc.matrix.srb.parser.impl.ReplicateParamsImpl.DataTargetTypeImpl.class), 5, ___uri, ___local));
                        return ;
                    }
                    break;
                case  3 :
                    revertToParentFromLeaveElement(___uri, ___local);
                    return ;
                case  2 :
                    if (("http://www.teragrid.org/schemas/datagrid" == ___uri)&&("DataSource" == ___local)) {
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
                case  5 :
                    state = 5;
                    return ;
                case  2 :
                    state = 2;
                    return ;
            }
            super.leaveChild(nextState);
        }

    }

}
