package Algorithm.algorithmrelay;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class SK {

	static int N, K;
	static int[][] map;
	static int[][] children;
	static int[][] cost;
	static int[] dr = new int[] { -1, 1, 0, 0 };
	static int[] dc = new int[] { 0, 0, -1, 1 };
	static int[] santa = new int[2];
	static int res = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			// ---------------입력 받기 시작
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			cost = new int[N][N];
			children = new int[K][2];
			res = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			st = new StringTokenizer(br.readLine());// 산타 위치
			santa[0] = Integer.parseInt(st.nextToken());// 행
			santa[1] = Integer.parseInt(st.nextToken());// 열

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				children[i][0] = Integer.parseInt(st.nextToken());// 행
				children[i][1] = Integer.parseInt(st.nextToken());// 열
			}

			Arrays.sort(children, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					if (o1[0] != o2[0])
						return o1[0] - o2[0];// 행
					else
						return o1[1] - o2[1];// 열
				}
			});

			merryXmas();

			// ----------------입력 받기 끝

			sb.append("#" + tc + " " + res + "\n");
		}
		System.out.println(sb.toString());
	}

	private static void merryXmas() {

		while (true) {
			for (int i = 0; i < N; i++)
				Arrays.fill(cost[i], Integer.MAX_VALUE);
			if (bfs() == -1)
				break;
		}

	}

	private static int bfs() {

		int idx = -1;
		int shortestPath = 1234567890;

		cost[santa[0]][santa[1]] = 0;

		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.add(new int[] { santa[0], santa[1], 0 });

		while (!q.isEmpty()) {

			int[] now = q.poll();

			for (int i = 0; i < 4; i++) {
				int r = now[0] + dr[i];
				int c = now[1] + dc[i];

				if (r >= 0 && r < N && c >= 0 && c < N) {
					int newCost = now[2] + Math.abs(map[r][c] - map[now[0]][now[1]]);
					if (cost[r][c] > newCost) {
						q.add(new int[] { r, c, newCost });
						cost[r][c] = newCost;
					}
				}
			}
		}

		for (int i = 0; i < K; i++) {
			if (children[i][0] == -1)
				continue;
			if (shortestPath > cost[children[i][0]][children[i][1]]) {
				idx = i;
				shortestPath = cost[children[i][0]][children[i][1]];
			}
		}

		if (idx != -1) {
			res += cost[children[idx][0]][children[idx][1]];
			System.out.println(
					children[idx][0] + " " + children[idx][1] + " " + cost[children[idx][0]][children[idx][1]]);
			santa[0] = children[idx][0];
			santa[1] = children[idx][1];
			children[idx][0] = -1;
		}

		return idx;

	}

}
