//package com.test.demo.calculate;
//
//import java.nio.channels.SelectionKey;
//import java.util.Iterator;
//
///**
// * @author naison
// * @since 3/4/2020 15:22
// */
//public class Demo {
//    public void run() {
//        while (true) {
//            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
//            while (iterator != null && iterator.hasNext()) {
//                SelectionKey sk = iterator.next();
//                NioSocketWrapper attachment = (NioSocketWrapper) sk.attachment();
//                iterator.remove();
//                if (attachment == null) {
//                    processKey(sk, attachment);
//                }
//            }
//        }//while
//    }
//
//}
