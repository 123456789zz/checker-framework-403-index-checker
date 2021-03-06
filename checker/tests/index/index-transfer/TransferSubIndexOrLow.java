import org.checkerframework.checker.index.qual.IndexFor;
import org.checkerframework.checker.index.qual.IndexOrHigh;
import org.checkerframework.checker.index.qual.IndexOrLow;
import org.checkerframework.checker.index.qual.LTLength;
import org.checkerframework.checker.index.qual.NonNegative;
import org.checkerframework.checker.index.qual.Unknown;

class TransferSubIndexOrLow {

	
	int[] arr = new int[5];
	int[] arrB = new int[5];
	
	// This error: can be suppressed
	//:: error: (assignment.type.incompatible)
	@IndexOrLow("arr") int i = -1;
	
	void subIndexFor(@IndexFor("arr") int v) {
		// Show result is of type LTLength
		@LTLength("arr") int lTLength1 = i - v;
		//:: error: (assignment.type.incompatible)
		@IndexOrLow("arr") int indexOrLow = i - v;
	}

	void subIndexOrLow(@IndexOrLow("arr") int v) {
		// Show result is of type Unknown
		@Unknown int nn1 = i - v;
		//:: error: (assignment.type.incompatible)
		@NonNegative int nn = i - v;
		//:: error: (assignment.type.incompatible)
		@LTLength("arr") int lTLength = i - v;
	}
	
	// not valid ie a.length - -1 !< length
	void subIndexOrHigh(@IndexOrHigh("arr") int v,  @LTLength("arr") int lTLength1, @LTLength("arr") int lTLength2) {
		
		int result = v - i;
		
		// Show result is of type LTLength
		//:: error: (assignment.type.incompatible)
		lTLength1 = result;
		result = lTLength2;
	}
	
	void sub1() {
		// Show result is of type LTLength
				@LTLength("arr") int lTLength1 = i - 1;
				//:: error: (assignment.type.incompatible)
				@IndexOrLow("arr") int indexOrLow = i - 1;
	}
	
	void sub0(@IndexOrLow("arr") int indexOrLow1, @IndexOrLow("arr") int indexOrLow2) {

		int result = i - 0;
		
		// Show result is of type IndexOrLow
		indexOrLow1 = result;
		result = indexOrLow2;
	}
	
	void subLTLength(@LTLength("arr") int v) {
		// Show result is of type Unknown
		@Unknown int nn1 = i - v;
		//:: error: (assignment.type.incompatible)
		@NonNegative int nn = i - v;
		//:: error: (assignment.type.incompatible)
		@LTLength("arr") int lTLength = i - v;
	}
	// not valid NN could be larger that length
	void subNonNegative(@NonNegative int v, @LTLength("arr") int lTLength1, @LTLength("arr") int lTLength2) {
		
		int result = v - i;
		
		// Show result is of type Unknown
		//:: error: (assignment.type.incompatible)
		lTLength1 = result;
		result = lTLength2;
	}

	void subUnknown(@Unknown int v) {
		// Show result is of type Unknown
		@Unknown int nn1 = i - v;
		//:: error: (assignment.type.incompatible)
		@NonNegative int nn = i - v;
		//:: error: (assignment.type.incompatible)
		@LTLength("arr") int lTLength = i - v;
	}
	// Not valid, IndexFor - IndexOrLow is unknown
	void subIndexForB(@IndexFor("arrB") int v,  @LTLength("arr") int lTLength1, @LTLength("arr") int lTLength2) {
		// Show result is of type LTLength
				lTLength1 = i - v;
				//:: error: (assignment.type.incompatible)
				@IndexOrLow("arr") int indexOrLow = i - v;
	}
	
	void subIndexOrLowB(@IndexOrLow("arrB") int v) {
		// Show result is of type Unknown
		@Unknown int nn1 = i - v;
		//:: error: (assignment.type.incompatible)
		@NonNegative int nn = i - v;
		//:: error: (assignment.type.incompatible)
		@LTLength("arr") int lTLength = i - v;
	}

	void subIndexOrHighB(@IndexOrHigh("arrB") int v,  @LTLength("arr") int lTLength1, @LTLength("arr") int lTLength2) {
		// Show result is of type LTLength
				lTLength1 = i - v;
				//:: error: (assignment.type.incompatible)
				@IndexOrLow("arr") int indexOrLow = i - v;
	}

	void subLTLengthB(@LTLength("arrB") int v) {
		// Show result is of type Unknown
		@Unknown int nn1 = i - v;
		//:: error: (assignment.type.incompatible)
		@NonNegative int nn = i - v;
		//:: error: (assignment.type.incompatible)
		@LTLength("arr") int lTLength = i - v;
	}
}