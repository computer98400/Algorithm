import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최종 {
	private static int Solution(int N, int K, int[][] map, ArrayList<Pair> childrens, Pair santa) {
		final int[] dy = { 0, 1, 0, -1 };
		final int[] dx = { 1, 0, -1, 0 };
		final int INF = 99999999;
		int[][] sum = new int[N][N];	// 최소 거리들을 모아놓은 배열
		int result = 0;

		while (!childrens.isEmpty()) {
			// INF로 초기화 하기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sum[i][j] = INF;
				}
			}

			PriorityQueue<Pair> pq = new PriorityQueue<>();
			sum[santa.y][santa.x] = 0;
			pq.add(new Pair(santa.y, santa.x, sum[santa.y][santa.x]));

			int tmpY, tmpX, tmpD;
			while (!pq.isEmpty()) {
				Pair p = pq.poll();

				for (int i = 0; i < 4; i++) {
					tmpY = p.y + dy[i];
					tmpX = p.x + dx[i];
					
					// 범위 초과 검사
					if (tmpY < 0 || tmpX < 0 || tmpY >= N || tmpX >= N) {
						continue;
					}

					// 점-점 사이의 거리 : |point_1 - point_2|
					tmpD = Math.abs(map[p.y][p.x] - map[tmpY][tmpX]);
					if (sum[tmpY][tmpX] > p.sum + tmpD) {
						sum[tmpY][tmpX] = p.sum + tmpD;
						pq.add(new Pair(tmpY, tmpX, sum[tmpY][tmpX]));
					}
				}
			}

			// 완전 탐색으로 거리가 가장 짧은 값 가져오기
			Pair answer = new Pair(-1, -1, INF);
			int idx = -1;
			for (int i = 0; i < childrens.size(); i++) {
				Pair p = childrens.get(i);
				if (answer.sum > sum[p.y][p.x]) {
					idx = i;
					answer.y = p.y;
					answer.x = p.x;
					answer.sum = sum[p.y][p.x];
				}
			}

			// 결과 및 santa 위치 갱신
			result += answer.sum;
			santa.y = answer.y;
			santa.x = answer.x;
			childrens.remove(idx);
		}

		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());	// 행렬 크기
			int K = Integer.parseInt(st.nextToken());	// 아이들 수

			int[][] map = new int[N][N];	// 높낮이를 나타낸 지도
			ArrayList<Pair> childrens = new ArrayList<>();	// 아이들, 조건: 겹치지 않음
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int tmp_x, tmp_y;

			st = new StringTokenizer(br.readLine());
			tmp_y = Integer.parseInt(st.nextToken());
			tmp_x = Integer.parseInt(st.nextToken());
			Pair santa = new Pair(tmp_y, tmp_x);	// 산타 위치

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				tmp_y = Integer.parseInt(st.nextToken());
				tmp_x = Integer.parseInt(st.nextToken());
				childrens.add(new Pair(tmp_y, tmp_x));
			}
			Collections.sort(childrens);
			
			System.out.printf("#%d %d\n", test_case, Solution(N, K, map, childrens, santa));	// #TC에 맞게 출력
		}

	}

	static class Pair implements Comparable<Pair> {
		int y;
		int x;
		int sum;

		public Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}

		public Pair(int y, int x, int sum) {
			this(y, x);
			this.sum = sum;
		}

		// 우선순위: sum 낮은 순 > 행 낮은 순 > 열 낮은 순
		@Override
		public int compareTo(Pair o) {
			if (this.sum != o.sum)
				return Integer.compare(this.sum, o.sum);
			if (this.y != o.y)
				return Integer.compare(this.y, o.y);
			return Integer.compare(this.x, o.x);
		}
		
		@Override
		public String toString() {
			return sum+" "+y+" "+x;
		}
	}
}
