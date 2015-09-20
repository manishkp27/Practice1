package com.solution2;

public class BishopMoves {
	public static void main(String[] args) {
		try {
			Integer[][] space = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 },
					{ -1, 0, -1 } };

			Node[][] nodeSpace = new Node[4][3];
			for (int i = 0; i <= 3; i++) {
				for (int j = 0; j <= 2; j++) {
					if (space[i][j] >= 0)
						nodeSpace[i][j] = new Node(space[i][j], i, j);
				}
			}

			Bishop bishop = new Bishop(space);
			Integer[] res = null;
			for (int i = 0; i <= 3; i++) {
				for (int j = 0; j <= 2; j++) {
					if (nodeSpace[i][j] != null) {
						for (int k = 0; k <= 3; k++) {
							if ((res = bishop.isValidMove1(i, j, k)) != null) {
								nodeSpace[i][j].next[k] = nodeSpace[res[0]][res[1]];
							}
						}
					}
				}
			}

			for (int i = 0; i <= 2; i++) {
				for (int j = 0; j <= 2; j++) {
					Node n1 = nodeSpace[i][j];
					for (int k1 = 0; k1 <= 3; k1++) {
						if (n1 != null && n1.next[k1] != null) {

							Node n2 = n1.next[k1];

							for (int k2 = 0; k2 <= 3; k2++) {
								if (n2 != null
										&& n2.next[k2] != null
										&& nodeSpace[i][j].data != n2.next[k2].data) {

									Node n3 = n2.next[k2];
									for (int k3 = 0; k3 <= 3; k3++) {
										if (n3 != null
												&& n3.next[k3] != null
												&& n1.next[k1].data != n3.next[k3].data) {
											Node n4 = n3.next[k3];
											for (int k4 = 0; k4 <= 3; k4++) {
												if (n4 != null
														&& n4.next[k4] != null
														&& n2.next[k2].data != n4.next[k4].data) {
													Node n5 = n4.next[k4];
													for (int k5 = 0; k5 <= 3; k5++) {
														if (n5 != null
																&& n5.next[k5] != null
																&& n3.next[k3].data != n5.next[k5].data) {
															System.out
																	.print("#"
																			+ nodeSpace[i][j].data
																			+ "#");
															System.out
																	.print(" #"
																			+ n1.next[k1].data
																			+ "# ");
															System.out
																	.print(" #"
																			+ n2.next[k2].data
																			+ "# ");
															System.out
																	.print(" #"
																			+ n3.next[k3].data
																			+ "# ");
															System.out
																	.print(" #"
																			+ n4.next[k4].data
																			+ "# ");
															System.out
																	.println(" #"
																			+ n5.next[k5].data
																			+ "# ");
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

class Node {
	int data;
	int x, y;
	Node[] next;

	public Node() {
	}

	public Node(int data, int i, int j) {
		this.data = data;
		this.x = i;
		this.y = j;
		this.next = new Node[4];
	}
}

class Bishop {
	Integer[][] space;

	public Bishop(Integer[][] space) {
		this.space = space;
	}

	Integer[] isValidMove1(int x, int y, int dir) {
		Integer[] res = null;
		switch (dir) {
		case 0:
			if (x > 0 && y > 0) {
				res = new Integer[2];
				res[0] = x - 1;
				res[1] = y - 1;
			}
			break;
		case 1:
			if (x > 0 && y < 2) {
				res = new Integer[2];
				res[0] = x - 1;
				res[1] = y + 1;
			}
			break;
		case 2:
			if (x < 3 && y < 2 && space[x + 1][y + 1] >= 0) {
				res = new Integer[2];
				res[0] = x + 1;
				res[1] = y + 1;
			}
			break;
		case 3:
			if (x < 3 && y > 0 && space[x + 1][y - 1] >= 0) {
				res = new Integer[2];
				res[0] = x + 1;
				res[1] = y - 1;
			}
		}
		return res;
	}

}
