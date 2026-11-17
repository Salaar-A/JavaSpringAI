package com.ecitcarp.practicespringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootApplication
//@EnableKafka
public class PracticeSpringBootApplication{

    public static void main(String[] args) throws Exception {
            SpringApplication.run(PracticeSpringBootApplication.class,args);
//        GridGenerator.printUnicodeGrid("https://docs.google.com/document/d/e/2PACX-1vSvM5gDlNvt7npYHhp_XfsJvuntUhq184By5xO_pA4b_gCWeXb6dM6ZxwN8rE6S4ghUsCj2VKR21oEP/pub");
    }
//    public class GridGenerator {
//
//        public static void printUnicodeGrid(String docUrl) throws Exception {
//            // Fetch the HTML
//            StringBuilder html = new StringBuilder();
//            BufferedReader reader = new BufferedReader(
//                    new InputStreamReader(new URL(docUrl).openStream()));
//            String line;
//            while ((line = reader.readLine()) != null) {
//                html.append(line);
//            }
//            reader.close();
//            Pattern tdPattern = Pattern.compile("<td[^>]*>(.*?)</td>", Pattern.DOTALL);
//            Matcher matcher = tdPattern.matcher(html.toString());
//
//            List<String> cells = new ArrayList<>();
//            while (matcher.find()) {
//                String cell = matcher.group(1)
//                        .replaceAll("<[^>]+>", "")
//                        .replace("&nbsp;", " ")
//                        .trim();
//                cells.add(cell);
//            }
//
//            int startIndex = 0;
//            for (int i = 0; i + 2 < cells.size(); i++) {
//                if (cells.get(i).equalsIgnoreCase("x-coordinate")
//                        && cells.get(i + 1).equalsIgnoreCase("Character")
//                        && cells.get(i + 2).equalsIgnoreCase("y-coordinate")) {
//                    startIndex = i + 3;
//                    break;
//                }
//            }
//
//            Map<String, String> points = new HashMap<>();
//            int maxX = 0, maxY = 0;
//
//            for (int i = startIndex; i + 2 < cells.size(); i += 3) {
//                String xStr = cells.get(i);
//                String ch = cells.get(i + 1);
//                String yStr = cells.get(i + 2);
//
//                if (xStr.isEmpty() || yStr.isEmpty()) continue;
//
//                int x, y;
//                try {
//                    x = Integer.parseInt(xStr);
//                    y = Integer.parseInt(yStr);
//                } catch (NumberFormatException e) {
//                    continue;
//                }
//
//                points.put(x + "," + y, ch);
//                maxX = Math.max(maxX, x);
//                maxY = Math.max(maxY, y);
//            }
//
//            for (int y = maxY; y >= 0; y--) {
//                StringBuilder row = new StringBuilder();
//                for (int x = 0; x <= maxX; x++) {
//                    row.append(points.getOrDefault(x + "," + y, " "));
//                }
//                System.out.println(row);
//            }
//        }
//    }
    }
