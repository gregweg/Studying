package BitManipulation;

import java.util.BitSet;

public class BitInt {
	BitSet bits;
	public BitInt() {
		bits = new BitSet(32);
	}
	
	public BitInt(int num) {
		char[] charBits = Integer.toBinaryString(num).toCharArray();
		bits = new BitSet(32);
		for (int i = 0; i < charBits.length; i++) {
			if (charBits[i] == '1') {
				bits.set(i, true);
			} else {
				bits.set(i, false);
			}
		}
	}
	
	public static int bitSetToInt(BitSet bitSet) {
		int bitInteger = 0;
		for(int i = 0; i < 32; i++) {
			if (bitSet.get(i))
				// assignment operator for bit position if set in bitSet
				bitInteger |= (1 << i);
		}
		return bitInteger;
	}
}
