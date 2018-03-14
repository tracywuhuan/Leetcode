//https://leetcode.com/problems/preimage-size-of-factorial-zeroes-function/description/
//

//My version but time limit exceed

class Solution {
    public int preimageSizeFZF(int K) {
	if (K < 0) {
		return 0;
	}
	long k2 = K;
	int count = 0;
	long prenum5 = 0;
	int flag = 0;
	Integer maxlong = Integer.MAX_VALUE;
	if(k2==0){
		count++;
	}
	for (long i = 1; i < maxlong; i++) {
		long num5 = 0;
							 
	if (k2 == 0 && i > 5) {
		break;
	}
	if (flag == 1) {// 上一次满足k了，那么后面5个都可以满足k
		if (i % 5 != 0) {
			count++;
			continue;
		} else {
			break;
		}
	}
			// for (long j = i; j <= i&&j!=0; j++) { //loop i!
			// if(j%2!=0&&j%5!=0){
			// continue;
			// }else{
	long tempj = i;

	num5 = prenum5;// 上一次5的个数
	while (tempj % 5 == 0) {
		tempj = tempj / 5;
		num5++;// 这次增加的5的个数
	}
				// }
				// }
	prenum5 = num5;
	k2 = k2 - num5;
			
	if (k2 == 0) {// 满足了
				//System.out.println("hit " + i + "!");
		count++;
		flag = 1;
	} else {
		flag = 0;
	}
	if (k2 < 0) {// 增加的太多了，直接退出，意思就是这i有好几个5分解出来，导致prenum5不是加1了，必然不满足当前k了，退出
		break;
	}
	k2 = K;
	}
	return count;
    }
}

//standard answer

class Solution {
    public int preimageSizeFZF(int K) {
        int lo = K, hi = 10*K + 1;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            int zmi = zeta(mi);
            if (zmi == K) return 5;
            else if (zmi < K) lo = mi + 1;
            else hi = mi;
        }
        return 0;
    }

    public int zeta(int x) {
        if (x == 0) return 0;
        return x/5 + zeta(x/5);
    }
}
