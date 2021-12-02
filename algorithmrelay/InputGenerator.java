package Algorithm.algorithmrelay;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class InputGenerator {
	static String fileName = null;
	static File file = null;
	static BufferedWriter bw = null;
	static Scanner sc = new Scanner(System.in);
	static int T;

	public static void main(String[] args) throws IOException {

		while (bw == null) {
			openFile();
		}

		makeTestCase();
		bw.close();
	}

	private static void makeTestCase() throws IOException {
		System.out.println("만들 테스트케이스 개수를 입력하세요");
		System.out.print("테스트케이스 개수:");
		T = sc.nextInt();
		bw.write(T+"\n");
		for (int i = 0; i < T; i++) {

			int N = (int) (Math.random() * 15 + 5);// N=5~20
			int K = (int) (Math.random() * 7 + 3);// K=3~10
			int[][] weight = new int[N][N];
			boolean[][] isTrue = new boolean[N][N];
			int[][] child = new int[K][2];

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (Math.random() < 0.3) {
						weight[r][c] = (int) (Math.random() * 10);// 0~10
					}
				}
			}

			int santa_r = (int) (Math.random() * N);
			int santa_c = (int) (Math.random() * N);
			isTrue[santa_r][santa_c] = true;

			int cnt = 0;

			while (cnt < K) {
				int child_r = (int) (Math.random() * N);
				int child_c = (int) (Math.random() * N);
				if (isTrue[child_r][child_c])
					continue;
				else {
					child[cnt][0] = child_r;
					child[cnt][1] = child_c;
					isTrue[child_r][child_c] = true;
					cnt++;
				}
			}

			writeTestCase(N, K, weight, santa_r, santa_c, child);

		}

	}

	private static void writeTestCase(int n, int k, int[][] weight, int santa_r, int santa_c, int[][] child)
			throws IOException {

		bw.write(n + " " + k + "\n");

		for (int r = 0; r < n; r++) {
			StringBuilder sb = new StringBuilder();
			for (int c = 0; c < n; c++) {
				sb.append(weight[r][c]).append(" ");
			}
			bw.write(sb.substring(0, sb.length()-1));
			bw.newLine();
		}

		bw.write(santa_r + " " + santa_c + "\n");
		for (int i = 0; i < k; i++) {
			bw.write(child[i][0] + " " + child[i][1] + "\n");
		}

	}

	@SuppressWarnings("resource")
	private static boolean openFile() throws IOException {

		System.out.println("input test case를 저장할 파일 명을 입력하세요 ex)sample_input.txt");
		System.out.print("파일명 :");
		fileName = sc.next();

		if (fileName != null && fileName.lastIndexOf(".txt") == fileName.length() - 4) {

			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName, true), "utf-8"));
			return true;
		}

		return false;
	}

}
