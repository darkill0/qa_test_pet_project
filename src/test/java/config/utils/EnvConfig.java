package config.utils;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvConfig {

    private static final Dotenv dotenv = Dotenv.configure()
            .directory(".")
            .ignoreIfMissing()
            .load();
    public static String getRemote(){
        String systemValue = System.getenv("SELENOID_REMOTE");
        if(systemValue != null && !systemValue.isEmpty()){
            return systemValue;
        }

        return dotenv.get("SELENOID_REMOTE");
    }
}
