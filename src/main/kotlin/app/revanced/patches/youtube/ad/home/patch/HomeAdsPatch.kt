/**
package app.revanced.patches.youtube.ad

import app.revanced.extensions.injectHideCall
import app.revanced.patcher.annotations.Compatibility
import app.revanced.patcher.annotations.Package
import app.revanced.patcher.data.implementation.BytecodeData
import app.revanced.patcher.extensions.or
import app.revanced.patcher.patch.implementation.BytecodePatch
import app.revanced.patcher.patch.implementation.metadata.PackageMetadata
import app.revanced.patcher.patch.implementation.metadata.PatchMetadata
import app.revanced.patcher.patch.implementation.misc.PatchResult
import app.revanced.patcher.patch.implementation.misc.PatchResultSuccess
import app.revanced.patcher.signature.MethodMetadata
import app.revanced.patcher.signature.MethodSignature
import app.revanced.patcher.signature.MethodSignatureMetadata
import app.revanced.patcher.signature.PatternScanMethod
import org.jf.dexlib2.AccessFlags
import org.jf.dexlib2.Opcode
import org.jf.dexlib2.iface.instruction.formats.Instruction11x


private val packageMetadata = listOf(
PackageMetadata(
"com.google.android.youtube",
listOf("17.03.38")
),
)

private val patchMetadata = PatchMetadata(
"home-ads",
"Home Ads Patch",
"Patch to remove ads in YouTube",
packageMetadata,
"0.0.1"
)

private val signatureDescription = "Required signature for ${patchMetadata.name}. Discovered in version 17.03.38."

class HomeAdsPatch : BytecodePatch(
patchMetadata,
listOf(
MethodSignature(
MethodSignatureMetadata(
"home-ads-method-1",
MethodMetadata(
"Ljke;",
"k",
),
PatternScanMethod.Fuzzy(2), // FIXME: Test this threshold and find the best value.
packageMetadata,
signatureDescription,
"0.0.1"
),
"Z",
AccessFlags.PRIVATE or AccessFlags.FINAL,
listOf("L"),
listOf(
Opcode.INVOKE_DIRECT,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.GOTO,
Opcode.IGET_OBJECT,
Opcode.IF_EQ,
Opcode.CONST,
Opcode.GOTO,
Opcode.CONST,
Opcode.INVOKE_DIRECT,
Opcode.MOVE_RESULT_OBJECT,
Opcode.INVOKE_DIRECT,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.INVOKE_STATIC,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.INVOKE_STATIC,
Opcode.IGET_OBJECT,
Opcode.GOTO,
Opcode.IGET_OBJECT,
Opcode.INVOKE_STATIC,
Opcode.MOVE_RESULT,
Opcode.IF_EQZ,
Opcode.IGET_OBJECT,
Opcode.IF_EQ,
)
),
MethodSignature(
MethodSignatureMetadata(
"home-ads-method-2",
MethodMetadata(
"Ljsi;",
"<init>",
),
PatternScanMethod.Fuzzy(2), // FIXME: Test this threshold and find the best value.
packageMetadata,
signatureDescription,
"0.0.1"
),
"V",
AccessFlags.PUBLIC or AccessFlags.CONSTRUCTOR,
listOf(
"L",
"I"
),
listOf(
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.CHECK_CAST,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.CHECK_CAST,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.CHECK_CAST,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.CHECK_CAST,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.CHECK_CAST,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.CHECK_CAST,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.CHECK_CAST,
Opcode.IPUT_OBJECT,
Opcode.NEW_INSTANCE,
Opcode.INVOKE_DIRECT,
Opcode.IPUT_OBJECT,
Opcode.IGET_OBJECT,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.CONST,
Opcode.CONST_4,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT,
Opcode.IPUT_BOOLEAN,
)
),
MethodSignature(
MethodSignatureMetadata(
"home-ads-method-3",
MethodMetadata(
"Ljrh;",
"<init>",
),
PatternScanMethod.Fuzzy(2), // FIXME: Test this threshold and find the best value.
packageMetadata,
signatureDescription,
"0.0.1"
),
"V",
AccessFlags.PROTECTED or AccessFlags.CONSTRUCTOR,
listOf(
"L",
"L",
"L",
"L",
"L",
"L",
"L",
"L",
"L",
"L",
"L",
"L",
"L",
"[B",
"[B",
"[B",
"[B"
),
listOf(
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.MOVE_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.CHECK_CAST,
Opcode.IPUT_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.CHECK_CAST,
Opcode.IPUT_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.CHECK_CAST,
Opcode.IPUT_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.CHECK_CAST,
Opcode.IPUT_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.CHECK_CAST,
Opcode.IPUT_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.NEW_INSTANCE,
Opcode.MOVE_OBJECT_FROM16,
Opcode.INVOKE_DIRECT,
Opcode.IPUT_OBJECT,
Opcode.NEW_INSTANCE,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.NEW_INSTANCE,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.CONST_16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.CONST_4,
Opcode.INVOKE_DIRECT,
Opcode.NEW_INSTANCE,
Opcode.MOVE_OBJECT_FROM16,
Opcode.CONST_16,
Opcode.INVOKE_DIRECT,
Opcode.NEW_INSTANCE,
Opcode.MOVE_OBJECT_FROM16,
Opcode.INVOKE_DIRECT,
Opcode.CONST_4,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.CONST_16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.INVOKE_DIRECT_RANGE,
Opcode.MOVE_OBJECT_FROM16
)
),
MethodSignature(
MethodSignatureMetadata(
"home-ads-method-4",
MethodMetadata(
"Ljrk;",
"<init>",
),
PatternScanMethod.Fuzzy(2), // FIXME: Test this threshold and find the best value.
packageMetadata,
signatureDescription,
"0.0.1"
),
"V",
AccessFlags.PUBLIC or AccessFlags.CONSTRUCTOR,
listOf("L", "I"),
listOf(
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.MOVE_OBJECT,
Opcode.CHECK_CAST,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.IPUT_OBJECT,
)
),
MethodSignature(
MethodSignatureMetadata(
"home-ads-method-5",
MethodMetadata(
"Ljrn;",
"<init>",
),
PatternScanMethod.Fuzzy(2), // FIXME: Test this threshold and find the best value.
packageMetadata,
signatureDescription,
"0.0.1"
),
"V",
AccessFlags.PUBLIC or AccessFlags.CONSTRUCTOR,
listOf("L", "I"),
listOf(
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.MOVE_OBJECT,
Opcode.CHECK_CAST,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.MOVE_OBJECT,
Opcode.CHECK_CAST,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.MOVE_OBJECT,
Opcode.CHECK_CAST,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.IPUT_OBJECT,
)
),
MethodSignature(
MethodSignatureMetadata(
"home-ads-method-6",
MethodMetadata(
"Ljrq;",
"<init>",
),
PatternScanMethod.Fuzzy(2), // FIXME: Test this threshold and find the best value.
packageMetadata,
signatureDescription,
"0.0.1"
),
"V",
AccessFlags.PROTECTED or AccessFlags.CONSTRUCTOR,
listOf(
"L",
"L",
"L",
"L",
"L",
"L",
"L",
"L",
"L",
"L",
"L",
"L",
"L",
"[B",
"[B",
"[B",
"[B"
),
listOf(
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.CHECK_CAST,
Opcode.IPUT_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.CHECK_CAST,
Opcode.IPUT_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
)
),
MethodSignature(
MethodSignatureMetadata(
"home-ads-method-7",
MethodMetadata(
"Ljrr;",
"<init>",
),
PatternScanMethod.Fuzzy(2), // FIXME: Test this threshold and find the best value.
packageMetadata,
signatureDescription,
"0.0.1"
),
"V",
AccessFlags.PUBLIC or AccessFlags.CONSTRUCTOR,
listOf(
"L",
"I",
"[B"
),
listOf(
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.MOVE_OBJECT,
Opcode.CHECK_CAST,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.MOVE_OBJECT,
Opcode.CHECK_CAST,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
)
),
MethodSignature(
MethodSignatureMetadata(
"home-ads-method-8",
MethodMetadata(
"Ljrt;",
"<init>",
),
PatternScanMethod.Fuzzy(2), // FIXME: Test this threshold and find the best value.
packageMetadata,
signatureDescription,
"0.0.1"
),
"V",
AccessFlags.PUBLIC or AccessFlags.CONSTRUCTOR,
listOf(
"L",
"L",
"L",
"L",
"L",
"L",
"L",
"L",
"L",
"L",
"L",
"L",
"L",
"[B",
"[B",
"[B",
"[B"
),
listOf(
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.CHECK_CAST,
Opcode.MOVE_OBJECT_FROM16,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.CHECK_CAST,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT,
Opcode.MOVE_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
)
),
MethodSignature(
MethodSignatureMetadata(
"home-ads-method-9",
MethodMetadata(
"Ljru;",
"<init>",
),
PatternScanMethod.Fuzzy(2), // FIXME: Test this threshold and find the best value.
packageMetadata,
signatureDescription,
"0.0.1"
),
"V",
AccessFlags.PROTECTED or AccessFlags.CONSTRUCTOR,
listOf(
"L",
"L",
"L",
"L",
"L",
"L",
"L",
"L",
"L",
"L",
"L",
"L",
"L",
"L",
"[B",
"[B",
"[B",
"[B"
),
listOf(
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.MOVE_OBJECT,
Opcode.CHECK_CAST,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.NEW_INSTANCE,
Opcode.INVOKE_DIRECT,
Opcode.IPUT_OBJECT,
)
),
MethodSignature(
MethodSignatureMetadata(
"home-ads-method-10",
MethodMetadata(
"Ljrv;",
"<init>",
),
PatternScanMethod.Fuzzy(2), // FIXME: Test this threshold and find the best value.
packageMetadata,
signatureDescription,
"0.0.1"
),
"V",
AccessFlags.PROTECTED or AccessFlags.CONSTRUCTOR,
listOf(
"L",
"L",
"L",
"L",
"L",
"L",
"L",
"L",
"L",
"L",
"L",
"L",
"L",
"[B",
"[B",
"[B",
"[B"
),
listOf(
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.CHECK_CAST,
Opcode.IPUT_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.IPUT_OBJECT,
Opcode.NEW_INSTANCE,
Opcode.MOVE_OBJECT_FROM16,
Opcode.INVOKE_DIRECT,
Opcode.IPUT_OBJECT,
Opcode.NEW_INSTANCE,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.NEW_INSTANCE,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.CONST_16,
Opcode.INVOKE_DIRECT,
Opcode.NEW_INSTANCE,
Opcode.MOVE_OBJECT_FROM16,
)
),
MethodSignature(
MethodSignatureMetadata(
"home-ads-method-11",
MethodMetadata(
"Ljpm;",
"lX",
),
PatternScanMethod.Fuzzy(2), // FIXME: Test this threshold and find the best value.
packageMetadata,
signatureDescription,
"0.0.1"
),
"V",
AccessFlags.PUBLIC or AccessFlags.FINAL or AccessFlags.BRIDGE or AccessFlags.SYNTHETIC,
listOf("L", "L"),
listOf(
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.CHECK_CAST,
Opcode.IPUT_OBJECT,
Opcode.IGET_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.CHECK_CAST,
Opcode.IPUT_OBJECT,
Opcode.IGET_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.CHECK_CAST,
Opcode.IPUT_OBJECT,
Opcode.IGET_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.CHECK_CAST,
Opcode.IPUT_OBJECT,
Opcode.IGET_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.CHECK_CAST,
Opcode.IPUT_OBJECT,
Opcode.IGET_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.CHECK_CAST,
Opcode.IPUT_OBJECT,
Opcode.IGET_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.CHECK_CAST,
Opcode.IPUT_OBJECT,
Opcode.IGET_OBJECT,
Opcode.INVOKE_STATIC,
)
),
MethodSignature(
MethodSignatureMetadata(
"home-ads-method-12",
MethodMetadata(
"Ljpr;",
"b",
),
PatternScanMethod.Fuzzy(2), // FIXME: Test this threshold and find the best value.
packageMetadata,
signatureDescription,
"0.0.1"
),
"V",
AccessFlags.PRIVATE or AccessFlags.FINAL,
listOf(),
listOf(
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.IGET_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.CHECK_CAST,
Opcode.IPUT_OBJECT,
Opcode.IGET_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.IGET_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.IGET_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.IGET_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.IGET_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IGET_OBJECT,
Opcode.IGET_OBJECT,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.NEW_INSTANCE,
Opcode.INVOKE_DIRECT,
Opcode.IPUT_OBJECT,
Opcode.CONST_4,
Opcode.INVOKE_VIRTUAL,
Opcode.CONST_4,
Opcode.INVOKE_VIRTUAL,
Opcode.RETURN_VOID
)
),
MethodSignature(
MethodSignatureMetadata(
"home-ads-method-13",
MethodMetadata(
"Ljqk;",
"<init>",
),
PatternScanMethod.Fuzzy(2), // FIXME: Test this threshold and find the best value.
packageMetadata,
signatureDescription,
"0.0.1"
),
"V",
AccessFlags.PROTECTED or AccessFlags.CONSTRUCTOR,
listOf(
"L",
"L",
"L",
"L",
"L",
"[B",
"[B"
),
listOf(
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.CONST_4,
Opcode.INVOKE_STATIC,
)
),
MethodSignature(
MethodSignatureMetadata(
"home-ads-method-14",
MethodMetadata(
"Ljqa;",
"b",
),
PatternScanMethod.Fuzzy(2), // FIXME: Test this threshold and find the best value.
packageMetadata,
signatureDescription,
"0.0.1"
),
"V",
AccessFlags.PRIVATE or AccessFlags.FINAL,
listOf(),
listOf(
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.IGET_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.CHECK_CAST,
Opcode.IPUT_OBJECT,
Opcode.IGET_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.CHECK_CAST,
Opcode.IPUT_OBJECT,
Opcode.IGET_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.CHECK_CAST,
Opcode.IPUT_OBJECT,
Opcode.IGET_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.IGET_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.IGET_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.IGET_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.RETURN_VOID
)
),
MethodSignature(
MethodSignatureMetadata(
"home-ads-method-15",
MethodMetadata(
"Ljra;",
"<init>",
),
PatternScanMethod.Fuzzy(2), // FIXME: Test this threshold and find the best value.
packageMetadata,
signatureDescription,
"0.0.1"
),
"V",
AccessFlags.PUBLIC or AccessFlags.CONSTRUCTOR,
listOf("L", "I"),
listOf(
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.MOVE_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.MOVE_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.MOVE_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.MOVE_OBJECT,
Opcode.CHECK_CAST,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.MOVE_OBJECT,
Opcode.CHECK_CAST,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.MOVE_OBJECT,
Opcode.CHECK_CAST,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.MOVE_OBJECT,
Opcode.CHECK_CAST,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.CHECK_CAST,
Opcode.IPUT_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.NEW_INSTANCE,
Opcode.MOVE_OBJECT_FROM16,
Opcode.INVOKE_DIRECT,
Opcode.IPUT_OBJECT,
Opcode.NEW_INSTANCE,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.IGET_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.IGET_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.IGET_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.IGET_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.IGET_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.IGET_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.IGET_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.IGET_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.NEW_INSTANCE,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.CONST_4,
Opcode.MOVE_OBJECT_FROM16,
Opcode.CONST_4,
Opcode.INVOKE_DIRECT,
Opcode.NEW_INSTANCE,
Opcode.MOVE_OBJECT_FROM16,
Opcode.CONST_4,
Opcode.INVOKE_DIRECT,
Opcode.NEW_INSTANCE,
Opcode.MOVE_OBJECT_FROM16,
Opcode.INVOKE_DIRECT,
Opcode.CONST_16,
Opcode.INVOKE_DIRECT_RANGE,
Opcode.MOVE_OBJECT_FROM16,
Opcode.IPUT_OBJECT,
Opcode.NEW_INSTANCE,
Opcode.IGET_OBJECT,
Opcode.IGET_OBJECT,
Opcode.IGET_OBJECT,
Opcode.IGET_OBJECT,
Opcode.IGET_OBJECT,
Opcode.IGET_OBJECT,
Opcode.CONST_4,
Opcode.CONST_4,
Opcode.CONST_16,
Opcode.CONST_16,
Opcode.CONST_16,
Opcode.MOVE_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT,
Opcode.MOVE_OBJECT,
Opcode.INVOKE_DIRECT_RANGE,
Opcode.IPUT_OBJECT,
Opcode.NEW_INSTANCE,
Opcode.CONST,
Opcode.MOVE_OBJECT_FROM16,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.CHECK_CAST,
Opcode.NEW_INSTANCE,
Opcode.CONST_4,
Opcode.INVOKE_DIRECT,
Opcode.INVOKE_DIRECT,
Opcode.IPUT_OBJECT,
Opcode.NEW_INSTANCE,
Opcode.MOVE_OBJECT_FROM16,
Opcode.INVOKE_DIRECT,
Opcode.IPUT_OBJECT,
Opcode.SGET_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.INVOKE_VIRTUAL,
Opcode.SGET_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.INVOKE_VIRTUAL,
Opcode.SGET_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.INVOKE_VIRTUAL,
Opcode.SGET_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.INVOKE_VIRTUAL,
Opcode.SGET_OBJECT,
Opcode.CONST_4,
Opcode.MOVE_OBJECT_FROM16,
Opcode.INVOKE_VIRTUAL,
Opcode.SGET_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.INVOKE_VIRTUAL,
Opcode.SGET_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.INVOKE_VIRTUAL,
Opcode.SGET_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.INVOKE_VIRTUAL,
Opcode.SGET_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.INVOKE_VIRTUAL,
Opcode.SGET_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.INVOKE_VIRTUAL,
Opcode.RETURN_VOID
)
),
MethodSignature(
MethodSignatureMetadata(
"home-ads-method-16",
MethodMetadata(
"Ljrd;",
"<init>",
),
PatternScanMethod.Fuzzy(2), // FIXME: Test this threshold and find the best value.
packageMetadata,
signatureDescription,
"0.0.1"
),
"V",
AccessFlags.PROTECTED or AccessFlags.CONSTRUCTOR,
listOf(
"L",
"L",
"L",
"L",
"L",
"L",
"L",
"L",
"L",
"L",
"L",
"L",
"L",
"[B",
"[B",
"[B",
"[B"
),
listOf(
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.MOVE_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.MOVE_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.CHECK_CAST,
Opcode.IPUT_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.CHECK_CAST,
Opcode.IPUT_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.CHECK_CAST,
Opcode.IPUT_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.CHECK_CAST,
Opcode.IPUT_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.CHECK_CAST,
Opcode.IPUT_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.CHECK_CAST,
Opcode.IPUT_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT,
Opcode.MOVE_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.NEW_INSTANCE,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.NEW_INSTANCE,
Opcode.MOVE_OBJECT_FROM16,
Opcode.CONST_4,
Opcode.INVOKE_DIRECT,
Opcode.CONST_4,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.INVOKE_DIRECT,
Opcode.IPUT_OBJECT,
Opcode.NEW_INSTANCE,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.NEW_INSTANCE,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.CONST_4,
Opcode.INVOKE_DIRECT,
Opcode.NEW_INSTANCE,
Opcode.MOVE_OBJECT_FROM16,
Opcode.CONST_4,
Opcode.INVOKE_DIRECT,
Opcode.NEW_INSTANCE,
Opcode.MOVE_OBJECT_FROM16,
Opcode.INVOKE_DIRECT,
Opcode.CONST_16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.INVOKE_DIRECT_RANGE,
Opcode.MOVE_OBJECT_FROM16,
Opcode.IPUT_OBJECT,
Opcode.NEW_INSTANCE,
Opcode.CONST_16,
Opcode.CONST_16,
Opcode.CONST_16,
Opcode.CONST_16,
Opcode.CONST_16,
Opcode.MOVE_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.INVOKE_DIRECT_RANGE,
Opcode.IPUT_OBJECT,
Opcode.NEW_INSTANCE,
Opcode.CONST_4,
Opcode.CONST_4,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.INVOKE_DIRECT_RANGE,
Opcode.IPUT_OBJECT,
Opcode.NEW_INSTANCE,
Opcode.CONST,
Opcode.MOVE_OBJECT_FROM16,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.CHECK_CAST,
Opcode.NEW_INSTANCE,
Opcode.CONST_4,
Opcode.INVOKE_DIRECT,
Opcode.INVOKE_DIRECT,
Opcode.IPUT_OBJECT,
Opcode.NEW_INSTANCE,
Opcode.MOVE_OBJECT_FROM16,
Opcode.INVOKE_DIRECT,
Opcode.IPUT_OBJECT,
Opcode.SGET_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.INVOKE_VIRTUAL,
Opcode.SGET_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.INVOKE_VIRTUAL,
Opcode.SGET_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.INVOKE_VIRTUAL,
Opcode.SGET_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.INVOKE_VIRTUAL,
Opcode.SGET_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.INVOKE_VIRTUAL,
Opcode.SGET_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.INVOKE_VIRTUAL,
Opcode.SGET_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.INVOKE_VIRTUAL,
Opcode.SGET_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.INVOKE_VIRTUAL,
Opcode.SGET_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.INVOKE_VIRTUAL,
Opcode.SGET_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.INVOKE_VIRTUAL,
Opcode.RETURN_VOID
)
),
MethodSignature(
MethodSignatureMetadata(
"home-ads-method-17",
MethodMetadata(
"Ljre;",
"<init>",
),
PatternScanMethod.Fuzzy(2), // FIXME: Test this threshold and find the best value.
packageMetadata,
signatureDescription,
"0.0.1"
),
"V",
AccessFlags.PROTECTED or AccessFlags.CONSTRUCTOR,
listOf(
"L",
"L",
"L",
"L",
"L",
"L",
"L",
"L",
"L",
"L",
"L",
"L",
"L",
"L",
"[B",
"[B",
"[B",
"[B"
),
listOf(
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.MOVE_OBJECT,
Opcode.CHECK_CAST,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.CHECK_CAST,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.MOVE_OBJECT,
Opcode.CHECK_CAST,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.MOVE_OBJECT,
Opcode.CHECK_CAST,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.MOVE_OBJECT,
Opcode.CHECK_CAST,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.MOVE_OBJECT,
Opcode.CHECK_CAST,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.MOVE_OBJECT,
Opcode.CHECK_CAST,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.IPUT_OBJECT,
Opcode.NEW_INSTANCE,
Opcode.INVOKE_DIRECT,
Opcode.IPUT_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.NEW_INSTANCE,
Opcode.IF_NEZ,
Opcode.MOVE_OBJECT_FROM16,
Opcode.GOTO,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.NEW_INSTANCE,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.CONST_4,
Opcode.INVOKE_DIRECT,
Opcode.NEW_INSTANCE,
Opcode.MOVE_OBJECT_FROM16,
Opcode.CONST_16,
Opcode.INVOKE_DIRECT,
Opcode.NEW_INSTANCE,
Opcode.MOVE_OBJECT_FROM16,
Opcode.INVOKE_DIRECT,
Opcode.CONST_16,
Opcode.CONST_16,
Opcode.CONST_16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.INVOKE_DIRECT_RANGE,
Opcode.IPUT_OBJECT,
Opcode.NEW_INSTANCE,
Opcode.CONST_4,
Opcode.CONST_4,
Opcode.CONST_4,
Opcode.CONST_16,
Opcode.MOVE_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT,
Opcode.MOVE_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.MOVE_OBJECT_FROM16,
Opcode.INVOKE_DIRECT_RANGE,
Opcode.IPUT_OBJECT,
Opcode.NEW_INSTANCE,
Opcode.CONST,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_RESULT_OBJECT,
Opcode.CHECK_CAST,
Opcode.NEW_INSTANCE,
Opcode.CONST_16,
Opcode.INVOKE_DIRECT,
Opcode.INVOKE_DIRECT,
Opcode.IPUT_OBJECT,
Opcode.NEW_INSTANCE,
Opcode.MOVE_OBJECT_FROM16,
Opcode.INVOKE_DIRECT,
Opcode.IPUT_OBJECT,
Opcode.SGET_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.INVOKE_VIRTUAL,
Opcode.SGET_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.INVOKE_VIRTUAL,
Opcode.SGET_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.INVOKE_VIRTUAL,
Opcode.SGET_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.INVOKE_VIRTUAL,
Opcode.SGET_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.INVOKE_VIRTUAL,
Opcode.SGET_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.INVOKE_VIRTUAL,
Opcode.SGET_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.INVOKE_VIRTUAL,
Opcode.SGET_OBJECT,
Opcode.MOVE_OBJECT_FROM16,
Opcode.INVOKE_VIRTUAL,
Opcode.MOVE_OBJECT_FROM16,
Opcode.IF_EQZ,
Opcode.SGET_OBJECT,
Opcode.INVOKE_VIRTUAL,
Opcode.RETURN_VOID
)
)
)
) {
override fun execute(data: BytecodeData): PatchResult {
for (i in 0 until signatures.count()) {
val signature = signatures.elementAt(i)
val result = signature.result!!
val implementation = result.method.implementation!!
val index = result.scanData.startIndex
val instructions = implementation.instructions

val register = (instructions[index + (if (i < 2) -1 else 1)] as Instruction11x).registerA
implementation.injectHideCall(index + 2, register)
}

return PatchResultSuccess()
}
}
 **/