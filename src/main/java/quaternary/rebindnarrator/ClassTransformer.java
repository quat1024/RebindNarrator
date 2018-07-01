package quaternary.rebindnarrator;

import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.IntInsnNode;
import org.objectweb.asm.tree.MethodNode;

import java.util.ListIterator;

public final class ClassTransformer implements IClassTransformer, Opcodes {
	// org.lwjgl.input.Keyboard.KEY_B
	private static final int KEY_B = 0x30;

	// Unused in org.lwjgl.input.Keyboard
	private static final int KEY_INVALID = 0x54;

	@Override
	public byte[] transform(String name, String transformedName, byte[] classBytes) {
		if (transformedName.equals("net.minecraft.client.Minecraft")) {
			final ClassReader classReader = new ClassReader(classBytes);
			final ClassNode classNode = new ClassNode();

			classReader.accept(classNode, 0);

			for (MethodNode methodNode : classNode.methods) {
				if (methodNode.name.equals("func_152348_aa") || methodNode.name.equals("dispatchKeypresses")) {
					ListIterator<AbstractInsnNode> nodeIterator = methodNode.instructions.iterator();

					// Search for "BIPUSH 48" in the method instructions
					// This marks the block responsible for toggling the narrator

					while (nodeIterator.hasNext()) {
						AbstractInsnNode node = nodeIterator.next();

						if (node.getOpcode() == BIPUSH && ((IntInsnNode) node).operand == KEY_B) {
							((IntInsnNode) node).operand = KEY_INVALID;
							break;
						}
					}
					break;
				}
			}

			// No need for flags since size or frames of class are unchanged
			ClassWriter classWriter = new ClassWriter(0);
			classNode.accept(classWriter);
			return classWriter.toByteArray();
		}

		return classBytes;
	}
}
