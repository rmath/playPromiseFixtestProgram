package controllers;

import jobs.MyJob;
import play.*;
import play.libs.F;
import play.mvc.*;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import models.*;

public class Application extends Controller {

    public static void index() {
        Logger.info("==> Begin of test...");

        List<F.Promise<String>> promises = new ArrayList<F.Promise<String>>();
        promises.add(new MyJob("1").now());
        promises.add(new MyJob("2").now());
        F.Promise<List<String>> globalPromise = F.Promise.waitAll(promises);
        try {
            globalPromise.get(10, TimeUnit.SECONDS);
            Logger.info("==> Exit after timeout");
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ExecutionException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (TimeoutException e) {
            Logger.info("==> OK exit in timeout");
        }


        Logger.info("==> End of Parent");

        ok();
    }

}