package kr.or.ddit.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class ChoiceReporter {

	public static void main(String[] args) {
		String[][] memberArr = new String[][] {
			{"박승우", "배문기", "박정수", "오미나", "이지영"},
			{"구기현", "정재균", "이성일", "전다미", "정은지"},
			{"오대환", "진현성", "김민욱", "신국현"},
			{"황지현", "조성희", "고영우", "홍기태", "전지혜"},
			{"이수진", "유이현", "박윤수"},  // "신현근", 
			{"조윤재", "김동혁", "변정민", "김지완", "김민정"}
		};                       
		
		String[] reporterArr = new String[memberArr.length];
		
		Random rnd = new Random();
		for(int i=0; i<memberArr.length; i++) {
			reporterArr[i] = memberArr[i][rnd.nextInt(memberArr[i].length)];
		}
		
		System.out.println("=== 발표자 ===");
		for(int i=0; i<reporterArr.length; i++) {
			System.out.println((i+1) + "조 발표자 : " + reporterArr[i]);
		}
		
		Collections.shuffle(Arrays.asList(reporterArr));
		System.out.println("발표 순서 : " + Arrays.toString(reporterArr));
		
		

	}

}
