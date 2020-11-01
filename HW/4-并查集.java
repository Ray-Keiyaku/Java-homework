class Main {
    public static void main(String[] args) {
        int size = 10;
        Pair[] dotSet = { new Pair(4, 3), new Pair(3, 8), new Pair(6, 5), new Pair(9, 4), new Pair(2, 1),
                new Pair(8, 9), new Pair(5, 0), new Pair(7, 2), new Pair(6, 1), new Pair(6, 7) };
        UnionFind test = new UnionFind(size);
        test.unionAll(dotSet);
        System.out.println(test.isConnected(8, 9));
        System.out.println(test.isConnected(6, 7));
        System.out.println(test.isConnected(4, 5));
    }
}

class UnionFind {
    // 标记某点位于的连通分量
    private int[] type;
    // 连通分量的大小
    private int[] size;

    public UnionFind(int s) {
        type = new int[s];
        size = new int[s];
        for (int i = 0; i < s; i++) {
            type[i] = i;
            size[i] = 1;
        }
        count = s;
    }

    // 返回root
    private int find(int p) {
        int r = p;
        while (type[p] != p) {
            p = type[p];
        }
        int tmp;
        // 压缩路径
        while (r != p) {
            tmp = type[r];
            type[r] = p;
            r = tmp;
        }
        return p;
    }

    // 返回两个点是否连接
    public String isConnected(int p, int q) {
        if (find(p) == find(q)) {
            return String.format("%d & %d is Connected！", p, q);
        } else {
            return String.format("%d & %d is Not Connected！", p, q);
        }
    }

    // 连接两点
    private void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        // 将小树合并到大树
        if (size[pRoot] > size[qRoot]) {
            type[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        } else {
            type[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        }
    }

    // 将线段一一连接
    public void unionAll(Pair[] dotSet) {
        for (Pair it : dotSet) {
            union(it.getLeft(), it.getRight());
        }
    }
}

class Pair {
    private int left;
    private int right;

    public Pair(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public int getLeft() {
        return this.left;
    }

    public int getRight() {
        return this.right;
    }
}