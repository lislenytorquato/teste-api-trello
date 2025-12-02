package helper;

import io.github.cdimascio.dotenv.Dotenv;

public class Env {

    private static final Dotenv dotenv = Dotenv.configure().load();

    public static String dotEnvOrSystem(String key){
        String env = dotenv.get(key);

        if (key.isBlank())
            env= System.getenv(key);

        return env;
    }
}
