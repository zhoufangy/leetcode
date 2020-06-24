package theoreticalBasis.template;

/**
 * Created by ZhouFangyuan on 2020-06-24.
 * Time: 00:33
 * Information:
 */
public void recur(int level, int param){
        
        //terminator
        if(level>MAX_LEVEL){
            //process result
            return;
        }
        
        //process current logic
        process(level,param);
        
        //drill down
        recur(level:level+1,newParam);
        
        //restore current status;
}
