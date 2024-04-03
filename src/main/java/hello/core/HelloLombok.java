package hello.core;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * packageName    : hello.core
 * fileName       : HelloLombok
 * author         : h.h.w
 * date           : 2024-04-03
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-03        h.h.w       최초 생성
 */
@Getter
@Setter
@NoArgsConstructor // 생성자
@ToString
public class HelloLombok {
    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("홍혁원");
        helloLombok.setAge(1);

        System.out.println("helloLombok.getName() = " + helloLombok.getName());
        System.out.println("helloLombok = " + helloLombok);
    }
}
