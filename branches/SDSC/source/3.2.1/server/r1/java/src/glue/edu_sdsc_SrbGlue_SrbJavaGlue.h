/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class edu_sdsc_SrbGlue_SrbJavaGlue */

#ifndef _Included_edu_sdsc_SrbGlue_SrbJavaGlue
#define _Included_edu_sdsc_SrbGlue_SrbJavaGlue
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    clConnectJ
 * Signature: (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_clConnectJ
  (JNIEnv *, jobject, jstring, jstring, jstring, jstring, jstring);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    srbListCollectJ
 * Signature: (IILjava/lang/String;Ljava/lang/String;[I)I
 */
JNIEXPORT jint JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_srbListCollectJ
  (JNIEnv *, jobject, jint, jint, jstring, jstring, jintArray);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    getFileListItem
 * Signature: (II)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_getFileListItem
  (JNIEnv *, jobject, jint, jint);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    clFinishJ
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_clFinishJ
  (JNIEnv *, jobject, jint);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    srbObjCopyNewJ
 * Signature: (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_srbObjCopyNewJ
  (JNIEnv *, jobject, jint, jstring, jstring, jstring, jstring, jstring);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    srbListResourceJ
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_srbListResourceJ
  (JNIEnv *, jobject, jint, jint);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    getResListItem
 * Signature: (II)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_getResListItem
  (JNIEnv *, jobject, jint, jint);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    getDefCollection
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_getDefCollection
  (JNIEnv *, jobject);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    getDefResource
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_getDefResource
  (JNIEnv *, jobject);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    getUser
 * Signature: (I)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_getUser
  (JNIEnv *, jobject, jint);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    getDomain
 * Signature: (I)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_getDomain
  (JNIEnv *, jobject, jint);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    getLocalCacheDir
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_getLocalCacheDir
  (JNIEnv *, jobject);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    srbObjReplicateJ
 * Signature: (IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_srbObjReplicateJ
  (JNIEnv *, jobject, jint, jint, jstring, jstring, jstring, jstring);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    srbCollReplicateJ
 * Signature: (IILjava/lang/String;Ljava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_srbCollReplicateJ
  (JNIEnv *, jobject, jint, jint, jstring, jstring);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    queryDataInCollJ
 * Signature: (IILjava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_queryDataInCollJ
  (JNIEnv *, jobject, jint, jint, jstring);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    queryDataJ
 * Signature: (IILjava/lang/String;Ljava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_queryDataJ
  (JNIEnv *, jobject, jint, jint, jstring, jstring);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    querySubCollInCollJ
 * Signature: (IILjava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_querySubCollInCollJ
  (JNIEnv *, jobject, jint, jint, jstring);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    getDataResultJ
 * Signature: (II)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_getDataResultJ
  (JNIEnv *, jobject, jint, jint);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    getCollResultJ
 * Signature: (II)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_getCollResultJ
  (JNIEnv *, jobject, jint, jint);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    getGenQueResultJ
 * Signature: (II)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_getGenQueResultJ
  (JNIEnv *, jobject, jint, jint);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    getNCollAttriJ
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_getNCollAttriJ
  (JNIEnv *, jobject);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    getNDataAttriJ
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_getNDataAttriJ
  (JNIEnv *, jobject);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    srbObjUnlinkJ
 * Signature: (IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_srbObjUnlinkJ
  (JNIEnv *, jobject, jint, jint, jstring, jstring, jstring);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    srbCreateCollectJ
 * Signature: (IILjava/lang/String;Ljava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_srbCreateCollectJ
  (JNIEnv *, jobject, jint, jint, jstring, jstring);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    srbModifyDatasetMetaDJ
 * Signature: (IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)I
 */
JNIEXPORT jint JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_srbModifyDatasetMetaDJ
  (JNIEnv *, jobject, jint, jint, jstring, jstring, jstring, jstring, jint);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    srbModifyCollectMetaDJ
 * Signature: (IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)I
 */
JNIEXPORT jint JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_srbModifyCollectMetaDJ
  (JNIEnv *, jobject, jint, jint, jstring, jstring, jstring, jstring, jint);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    importToOldObjJ
 * Signature: (IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_importToOldObjJ
  (JNIEnv *, jobject, jint, jint, jstring, jstring, jstring, jstring, jstring, jstring);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    importToNewObjJ
 * Signature: (IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_importToNewObjJ
  (JNIEnv *, jobject, jint, jint, jstring, jstring, jstring, jstring, jstring);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    importDirJ
 * Signature: (IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_importDirJ
  (JNIEnv *, jobject, jint, jint, jstring, jstring, jstring, jstring);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    srbRmCollJ
 * Signature: (IILjava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_srbRmCollJ
  (JNIEnv *, jobject, jint, jint, jstring);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    srbUnregCollJ
 * Signature: (IILjava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_srbUnregCollJ
  (JNIEnv *, jobject, jint, jint, jstring);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    copyToOldObjJ
 * Signature: (IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_copyToOldObjJ
  (JNIEnv *, jobject, jint, jint, jstring, jstring, jstring, jstring, jstring, jstring, jstring, jstring);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    copyDataToCollJ
 * Signature: (IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_copyDataToCollJ
  (JNIEnv *, jobject, jint, jint, jstring, jstring, jstring, jstring, jstring, jstring, jstring, jstring);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    copyCollToCollJ
 * Signature: (IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_copyCollToCollJ
  (JNIEnv *, jobject, jint, jint, jstring, jstring, jstring, jstring);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    exportToFileJ
 * Signature: (IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)I
 */
JNIEXPORT jint JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_exportToFileJ
  (JNIEnv *, jobject, jint, jint, jstring, jstring, jstring, jstring, jint);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    exportToDirJ
 * Signature: (IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_exportToDirJ
  (JNIEnv *, jobject, jint, jint, jstring, jstring, jstring, jstring);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    exportCollToDirJ
 * Signature: (IILjava/lang/String;Ljava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_exportCollToDirJ
  (JNIEnv *, jobject, jint, jint, jstring, jstring);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    srbGenQuery
 * Signature: (II[Ljava/lang/String;[I[I)I
 */
JNIEXPORT jint JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_srbGenQuery
  (JNIEnv *, jobject, jint, jint, jobjectArray, jintArray, jintArray);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    srbRegisterDatasetJ
 * Signature: (IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)I
 */
JNIEXPORT jint JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_srbRegisterDatasetJ
  (JNIEnv *, jobject, jint, jint, jstring, jstring, jstring, jstring, jstring, jint);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    srbUnregisterDatasetJ
 * Signature: (IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_srbUnregisterDatasetJ
  (JNIEnv *, jobject, jint, jint, jstring, jstring, jstring);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    srbRegisterDirJ
 * Signature: (IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_srbRegisterDirJ
  (JNIEnv *, jobject, jint, jint, jstring, jstring, jstring);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    getMoreDataRowsJ
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_getMoreDataRowsJ
  (JNIEnv *, jobject, jint, jint);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    getMoreCollRowsJ
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_getMoreCollRowsJ
  (JNIEnv *, jobject, jint, jint);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    getMoreGenQueRowsJ
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_getMoreGenQueRowsJ
  (JNIEnv *, jobject, jint, jint);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    chmodInCollJ
 * Signature: (IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_chmodInCollJ
  (JNIEnv *, jobject, jint, jint, jstring, jstring, jstring, jstring);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    ingestUserJ
 * Signature: (IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_ingestUserJ
  (JNIEnv *, jobject, jint, jint, jstring, jstring, jstring, jstring, jstring, jstring, jstring, jstring);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    ingestGroupJ
 * Signature: (IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_ingestGroupJ
  (JNIEnv *, jobject, jint, jint, jstring, jstring, jstring, jstring, jstring);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    ingestLocJ
 * Signature: (IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_ingestLocJ
  (JNIEnv *, jobject, jint, jint, jstring, jstring, jstring, jstring, jstring);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    ingestTokenJ
 * Signature: (IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_ingestTokenJ
  (JNIEnv *, jobject, jint, jint, jstring, jstring, jstring);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    ingestResourceJ
 * Signature: (IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)I
 */
JNIEXPORT jint JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_ingestResourceJ
  (JNIEnv *, jobject, jint, jint, jstring, jstring, jstring, jstring, jstring, jint);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    ingestLogRescJ
 * Signature: (IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_ingestLogRescJ
  (JNIEnv *, jobject, jint, jint, jstring, jstring, jstring);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    addLogRescJ
 * Signature: (IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_addLogRescJ
  (JNIEnv *, jobject, jint, jint, jstring, jstring, jstring);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    addCompRescJ
 * Signature: (IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_addCompRescJ
  (JNIEnv *, jobject, jint, jint, jstring, jstring, jstring);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    modifyUserJ
 * Signature: (IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_modifyUserJ
  (JNIEnv *, jobject, jint, jint, jint, jstring, jstring, jstring);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    containerCreateJ
 * Signature: (IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)I
 */
JNIEXPORT jint JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_containerCreateJ
  (JNIEnv *, jobject, jint, jint, jstring, jstring, jstring, jint);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    containerDeleteJ
 * Signature: (IILjava/lang/String;I)I
 */
JNIEXPORT jint JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_containerDeleteJ
  (JNIEnv *, jobject, jint, jint, jstring, jint);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    containerSyncJ
 * Signature: (IILjava/lang/String;I)I
 */
JNIEXPORT jint JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_containerSyncJ
  (JNIEnv *, jobject, jint, jint, jstring, jint);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    getSrbErrorString
 * Signature: (I)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_getSrbErrorString
  (JNIEnv *, jobject, jint);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    deleteValueJ
 * Signature: (IILjava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_deleteValueJ
  (JNIEnv *, jobject, jint, jint, jstring);

/*
 * Class:     edu_sdsc_SrbGlue_SrbJavaGlue
 * Method:    modifyZoneJ
 * Signature: (IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)I
 */
JNIEXPORT jint JNICALL Java_edu_sdsc_SrbGlue_SrbJavaGlue_modifyZoneJ
  (JNIEnv *, jobject, jint, jint, jstring, jstring, jstring, jstring, jstring, jstring, jint);

#ifdef __cplusplus
}
#endif
#endif