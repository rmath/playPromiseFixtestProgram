package jobs;

import play.Logger;
import play.jobs.Job;

public class MyJob extends Job {
    private String name="";

    public MyJob(String name){
        this.name=name;
    }


    /**
     * Here you do the job
     */
    @Override
    public String doJobWithResult() throws Exception {
        int tempo=0;
        for (tempo=0; tempo<20; tempo++){
            Logger.info("The job "+name+" works "+tempo);
            Thread.sleep(1000);
        }

        Logger.info("End of MyJob "+name);

        return "End job "+name;
    }


}
