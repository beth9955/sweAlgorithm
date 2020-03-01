package oi.algorithm.march;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class March5th {
    private BufferedReader br;

    public March5th(BufferedReader br) {
        this.br = br;
    }

    /**
     * SW Expert Academy 1228번
     *
     * @throws Exception
     */
    public void no1228() throws Exception {
        try {
            for (int i = 0; i < 10; i++) {

                /** 문제읽기 **/
                int inital = Integer.parseInt(br.readLine());
                Stream<String> stream = Stream.of(br.readLine().split(" "));
                int commands = Integer.parseInt(br.readLine());
                List<String> commandList = Arrays.asList(br.readLine().split("I "));

                /** 문제의 암호화 **/
                List<String> result = stream.collect(Collectors.toList()); //Arrays.asList하면 addAll이 exception
                for (int j = 1; j <= commands; j++) {
                    result = encrypt(result, commandList.get(j).trim());
                }

                /** 답 프린트 **/
                System.out.printf("#%d", i + 1);
                for (int n = 0; n < 10; n++) {
                    System.out.print(" " + result.get(n));
                }
                System.out.println();

            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * SW Expert Academy 1228번
     *
     * @throws Exception
     */
    public static List<String> encrypt(List<String> result, String commands) throws Exception {
        try {
            List<String> list = Arrays.asList(commands.split(" "));
            int pos = Integer.parseInt(list.get(0));
            int count = Integer.parseInt(list.get(1));
            int max = count + 2;

            List<String> temp = new ArrayList<>();
            for (int i = 2; i < max; i++) {
                temp.add(list.get(i));
            }

            result.addAll(pos, temp);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return result;
    }

    /**
     * SW Expert Academy 1229번
     *
     * @throws Exception
     */
    public void no1229() throws Exception {
        try {
            for (int i = 0; i < 10; i++) {

                /** 문제읽기 **/
                int inital = Integer.parseInt(br.readLine());
                Stream<String> stream = Stream.of(br.readLine().split(" "));
                int commands = Integer.parseInt(br.readLine());
                List<String> raw = Arrays.asList(br.readLine().split(" "));

                /** 명령어를 insert와 delete로 구분해서 저장 **/
                List<List<String>> commandList = new ArrayList<>();
                List<String> insert = new ArrayList<>();
                List<String> delete = new ArrayList<>();

                String separater = "I";
                for (String str : raw) {
                    if (!Character.isDigit(str.charAt(0))) {
                        if (!insert.isEmpty()) {
                            commandList.add(insert);
                        } else if (!delete.isEmpty()) {
                            commandList.add(delete);
                        }

                        separater = str;
                        insert = new ArrayList<>();
                        delete = new ArrayList<>();
                    }

                    if (separater.equals("I")) {
                        insert.add(str);
                    } else if (separater.equals("D")) {
                        delete.add(str);
                    }
                }
                if (!insert.isEmpty()) {//마지막 한번이 누락되어서 추가.
                    commandList.add(insert);
                } else if (!delete.isEmpty()) {
                    commandList.add(delete);
                }

                /** 문제의 암호화 **/
                List<String> result = stream.collect(Collectors.toList()); //Arrays.asList하면 addAll이 exception
                for (int j = 0; j < commands; j++) {
                    String operation = commandList.get(j).get(0);

                    result = (operation.equals("I")) ? encryptInsert(result, commandList.get(j)) : encrypteDelete(result, commandList.get(j));

                }

                /** 답 프린트 **/
                System.out.printf("#%d", i + 1);
                for (int n = 0; n < 10; n++) {
                    System.out.print(" " + result.get(n));
                }
                System.out.println();

            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * SW Expert Academy 1229번
     *
     * @throws Exception
     */
    public static List<String> encryptInsert(List<String> result, List<String> commands) throws Exception {
        try {
            int pos = Integer.parseInt(commands.get(1));
            int count = Integer.parseInt(commands.get(2));
            int max = count + 3;

            List<String> temp = new ArrayList<>();
            for (int i = 3; i < max; i++) {
                temp.add(commands.get(i));
            }

            result.addAll(pos, temp);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return result;
    }

    /**
     * SW Expert Academy 1229번
     *
     * @throws Exception
     */
    public static List<String> encrypteDelete(List<String> result, List<String> commands) throws Exception {
        try {
            int pos = Integer.parseInt(commands.get(1));
            int count = Integer.parseInt(commands.get(2));

            result.subList(pos, pos + count).clear();

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return result;
    }


    /**
     * SW Expert Academy 1230번
     *
     * @throws Exception
     */
    public void no1230() throws Exception {
        try {
            for (int i = 0; i < 10; i++) {

                /** 문제읽기 **/
                int inital = Integer.parseInt(br.readLine());
                Stream<String> stream = Stream.of(br.readLine().split(" "));
                int commands = Integer.parseInt(br.readLine());
                List<String> raw = Arrays.asList(br.readLine().split(" "));

                /** 명령어를 insert와 delete로 구분해서 저장 **/
                List<List<String>> commandList = new ArrayList<>();
                List<String> insert = new ArrayList<>();
                List<String> delete = new ArrayList<>();
                List<String> add = new ArrayList<>();

                String separater = "I";
                do {
                    if (!insert.isEmpty()) {
                        commandList.add(insert);
                    } else if (!delete.isEmpty()) {
                        commandList.add(delete);
                    } else if (!add.isEmpty()){
                        commandList.add(add);
                    }

                    for (String str : raw) {
                        if (!Character.isDigit(str.charAt(0))) {
                            if (!insert.isEmpty()) {
                                commandList.add(insert);
                            } else if (!delete.isEmpty()) {
                                commandList.add(delete);
                            } else if (!add.isEmpty()){
                                commandList.add(add);
                            }

                            separater = str;
                            insert = new ArrayList<>();
                            delete = new ArrayList<>();
                            add = new ArrayList<>();
                        }

                        if (separater.equals("I")) {
                            insert.add(str);
                        } else if (separater.equals("D")) {
                            delete.add(str);
                        } else if (separater.equals("A")) {
                            add.add(str);
                        }
                    }
                } while (commandList.size() <= commands);


                /** 문제의 암호화 **/
                List<String> result = stream.collect(Collectors.toList()); //Arrays.asList하면 addAll이 exception
                for (int j = 0; j < commands; j++) {
                    String operation = commandList.get(j).get(0);

                    switch(operation) {
                        case "I" : result = encryptInsert(result, commandList.get(j)); break;
                        case "D" : result = encrypteDelete(result, commandList.get(j)); break;
                        case "A" : result = encryptAdd(result, commandList.get(j)); break;
                    }
                }

                /** 답 프린트 **/
                System.out.printf("#%d", i + 1);
                for (int n = 0; n < 10; n++) {
                    System.out.print(" " + result.get(n));
                }
                System.out.println();

            }

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * SW Expert Academy 1230번
     *
     * @throws Exception
     */
    public static List<String> encryptAdd(List<String> result, List<String> commands) throws Exception {
        try {
            int count = Integer.parseInt(commands.get(1));
            int max = count + 2;

            List<String> temp = new ArrayList<>();
            for (int i = 2; i < max; i++) {
                temp.add(commands.get(i));
            }

            result.addAll(temp);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return result;
    }


}
