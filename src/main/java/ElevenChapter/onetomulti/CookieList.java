package ElevenChapter.onetomulti;

/**
 * @author zhangmiao3
 * @Description:
 * @date 17:35 2018/7/6
 */
import java.util.ArrayList;
import java.util.List;

public class CookieList {

    public static final int MAX_SIZE = 1;
    private List<String> list = new ArrayList<String>();

    public synchronized void product(){
        try{

            if(list.size()==MAX_SIZE)
                this.wait();

            list.add("cookie"+((int)(Math.random()*10)+1));
            System.out.println("生产者生产了"+list.get(0));
            this.notify();

        }catch(InterruptedException e){

        }
    }

    public synchronized void customer(){

        try{
            //注意while
            while(list.size()==0)
                this.wait();
            System.out.println("消费者消费了:"+list.get(0));
            list.remove(0);
            this.notifyAll();
        }catch(InterruptedException e){

        }
    }

}