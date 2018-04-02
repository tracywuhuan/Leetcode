//https://leetcode-cn.com/problems/reaching-points/description/
//
class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if(sx==tx&&sy==ty){
            return true;
        }
        if(tx<sx||ty<sy){//源点比终点小，必定到不了
            return false;
        }
	//下面两个判断是为了减少时间, 起点有一个坐标轴跟终点一样,终点有一个坐标特别大,直接判断能否到达
        if(sx==Math.min(tx,ty)){
            if((Math.max(tx,ty)-sy)%sx==0) return true;
            else return false;
        }
        if(sy==Math.min(tx,ty)){
            if((Math.max(tx,ty)-sx)%sy==0) return true;
            else return false;
        }
        int px,py;
        while(true){
            if(tx<Math.min(sx,sy)||ty<Math.min(sx,sy)){
                return false;
            }
            px = tx;
            py = ty;
            tx = Math.min(tx,ty);
            ty = Math.abs(px-py);
            if((sx==tx&&sy==ty)||(sx==ty&&sy==tx)){
                return true;
            }

        }    
    }
}
