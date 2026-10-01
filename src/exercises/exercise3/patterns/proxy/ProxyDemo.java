package exercises.exercise3.patterns.proxy;

import java.util.HashMap;
import java.util.Map;

/** Caches user information so repeated requests avoid another data load. */
public final class ProxyDemo {

    private ProxyDemo() {
    }

    public static void run() {
        RealUserService realService = new RealUserService();
        UserService service = new UserServiceCacheProxy(realService);
        System.out.println(service.getUserInfo(7));
        System.out.println(service.getUserInfo(7));
        System.out.println("Loads after a cache hit: " + realService.loadCount());
        ((UserServiceCacheProxy) service).clearCache();
        System.out.println(service.getUserInfo(7));
        System.out.println("Loads after clearing cache: " + realService.loadCount());
    }

    private interface UserService {
        String getUserInfo(int userId);
    }

    private static final class RealUserService implements UserService {
        private int loads;

        public String getUserInfo(int userId) {
            loads++;
            return "User " + userId + " information";
        }

        int loadCount() { return loads; }
    }

    private static final class UserServiceCacheProxy implements UserService {
        private final UserService realService;
        private final Map<Integer, String> cache = new HashMap<>();

        private UserServiceCacheProxy(UserService realService) { this.realService = realService; }

        public String getUserInfo(int userId) {
            return cache.computeIfAbsent(userId, realService::getUserInfo);
        }

        void clearCache() { cache.clear(); }
    }
}
