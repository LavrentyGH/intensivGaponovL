package com.notificationdunice.intensivgaponovl;

import com.notificationdunice.intensivgaponovl.tasc1.BuildNumbStringBuilder;
import com.notificationdunice.intensivgaponovl.tasc1.FindMax;
import com.notificationdunice.intensivgaponovl.tasc1.RemoveDuplicatesFromList;
import com.notificationdunice.intensivgaponovl.tasc2.DaemonExample;
import com.notificationdunice.intensivgaponovl.tasc2.ForkJoinExample;
import com.notificationdunice.intensivgaponovl.tasc2.SetTreadSafeExam;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@SpringBootApplication
public class IntensivGaponovLApplication {

    public static void main(String[] args) {
        System.out.println("Задача 1.1");
        System.out.println("java -Xms512m -Xmx1024m -Xss2m -XX:+UseZGC -XX:+DoEscapeAnalysis -XX:+AggressiveOpts -jar myapp.jar");
        System.out.println("Задача 1.2");
        BuildNumbStringBuilder numbStringBuilder = new BuildNumbStringBuilder();
        numbStringBuilder.print();
        System.out.println("Задача 1.3");
        RemoveDuplicatesFromList removeDuplicatesFromList = new RemoveDuplicatesFromList();
        System.out.println(removeDuplicatesFromList
                .withoutChangingOrderElements(List.of(1,2,3,1,2,4,6,5,6,5,8,7)));
        System.out.println("Задача 1.4");
        FindMax findMax = new FindMax();
        findMax.max(List.of(2,56,98,2,3,4,1,5,7,777));

        System.out.println("Задача 1.5");
//        @Service
//        @RequiredArgsConstructor
//        public class UserService {
//            private final UserRepository userRepository;
//            private final UserMapper userMapper;
//
//            public UserDTO getUserDtoById(Long id) {
//                return userRepository.findById(id)
//                        .map(userMapper::toDto)
//                        .orElseThrow(() -> new UserNotFoundException("Пользователь с ID " + id + " не найден"));
//            }
//        }
        System.out.println("Задача 2.1");
        SetTreadSafeExam setTreadSafeExam = new SetTreadSafeExam();
        try {
            setTreadSafeExam.ran();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Задача 2.2");
        ForkJoinExample forkJoinExample = new ForkJoinExample();
        try {
            forkJoinExample.forkJoin();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Задача 2.3");
        DaemonExample daemonExample = new DaemonExample();
        daemonExample.demon();

        SpringApplication.run(IntensivGaponovLApplication.class, args);
    }
}
