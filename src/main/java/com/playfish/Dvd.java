package com.playfish;

public class Dvd {

	public Copy borrow(Member member) {
		
		Copy result = new Copy();
		result.onLoanTo = member;
		return result;
	}
}
