package kr.or.ddit.basic;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FileIOTest04 {

	public static void main(String[] args) {
		// 사용자가 입력한 내용을 그대로 파일로 저장하기
		try {
			/*
			// System.in  ==> 콘솔(표준입출력장치) 입력장치와 연결된 스트림
			   
			System.out.print("아무거나 입력하세요 >> ");
			int c = System.in.read();
			System.out.println("입력 값 : " + (char)c);
			*/
			
			// 바이트 기반 스트림을 문자 기반 스트림으로 변환하는 보조 스트림 객체
			// InputStreamReader   ==> 입력용
			// OutputStreamWriter  ==> 출력용
			InputStreamReader isr = new InputStreamReader(System.in);
			
			FileWriter fw = new FileWriter("d:/d_other/testChar.txt");
			
			System.out.println("아무 내용이나 입력하세요. (입력의 끝은 Ctrl + Z입니다.)");
			
			int c;
			
			// 콘솔에서 입력할 때 입력의 끝은 'Ctrl' + 'Z'키를 누르면 된다.
			while( (c = isr.read() ) != -1) {
				fw.write(c);	// 콘솔로 입력 받은 데이터를 파일에 출력한다.
			}
			
			// 스트림 닫기
			fw.close();
			isr.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
