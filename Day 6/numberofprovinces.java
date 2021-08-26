class Solution {
     public int findCircleNum(int[][] isConnected) {


        UnionFind u1 = new UnionFind(isConnected.length);

        // fill the data structure with the conected nodes
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                // dont conect nodes with itself
                if (i == j) continue;

                if (isConnected[i][j] == 1) {
                    u1.union(i, j);
                }
            }
        }

        return u1.connectedNodes();
    }


    private class UnionFind {

        private int root[];
        private int rank[];
        private HashSet<Integer> set;

        public UnionFind(int size) {
            root = new int[size];
            rank = new int[size];
            set = new HashSet();

            for (int i = 0; i < size; i ++) {
                root[i] = i;
                rank[i] = 1;
            }

        }

        public int find(int x) {
            if (x == root[x]) return x;
            return root[x] = find(root[x]);
        }

        public void union(int x, int y) {

            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else {
                    root[rootY] = rootX;
                    rank[rootX] += 1;
                }
            }
        }

        public int connectedNodes() {
            for (int i = 0; i < root.length; i++) {
                int x = find(root[i]);
                set.add(x);
            }

            return set.size();
        }
    }
}
