package porxy;

/**
 * @author liuzihao
 * @create 2022-01-24-14:50
 */
public interface UserManager {
    /**
     * 新增用户抽象方法
     */

    void addUser(String userName,String password);
    /**
     * 删除用户抽象方法
     */
    void delUser(String userName);
}
