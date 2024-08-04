package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Arrays;

public class BOJ_1043 {

    public static int[] parent;
    public static ArrayList<Integer>[] party;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 사람의 수
        int m = Integer.parseInt(st.nextToken()); // 파티의 수

        st = new StringTokenizer(br.readLine());
        int truthManCount = Integer.parseInt(st.nextToken());
        int[] truthMan = new int[truthManCount];
        for(int i = 0 ; i < truthManCount ; i++) {
            truthMan[i] = Integer.parseInt(st.nextToken());
        }
        // 유니온파인드 노드 초기화
        parent = new int[n + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        party = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            party[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int partyManCount = Integer.parseInt(st.nextToken());
            for(int j = 0 ; j < partyManCount ; j++) {
                party[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        // 동일 파티 참석 인원은 동일 집합으로 분류
        for (int i = 0; i < m; i++) {
            int first = party[i].get(0);
            for (int j = 1; j < party[i].size(); j++) {
                // union method => 1, j
                union(first, party[i].get(j));
            }
        }

        int count = 0;

        // 각 파티를 / 진짜쟁이들을 순회하면서 서로의 부모가 일치한지 봐야함
        for (int i = 0; i < m; i++) {
            boolean flag = false;
            int first = party[i].get(0);
            for (int j = 0; j < truthManCount; j++) {
                if(isSameUnion(first, truthMan[j])) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                count++;
            }
        }
        System.out.println(count);

    }


    public static void union(int first, int member) {
        // u 의 부모 찾기
        int pFirst = find(first);
        // v 의 부모 찾기
        int pMember = find(member);

        // 둘이 부모가 다르면 연결시켜주자 == 같은 집합으로 만들기
        if(pFirst != pMember){
            parent[pMember] = pFirst;
        }

    }

    public static int find(int u) {
        if (parent[u] == u) {
            // 부모와 내가 같다  == 끝
            return u;
        }
        return parent[u] = find(parent[u]);
    }

    public static boolean isSameUnion(int member, int truth) {
        int pMember = find(member);
        int pTruth = find(truth);
        return pMember == pTruth;
    }
}
