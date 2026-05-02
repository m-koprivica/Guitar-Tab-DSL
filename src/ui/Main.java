package ui;

import libs.Node;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import parser.GLangLexer;
import parser.GLangParser;
import parser.ParseTreeToAST;
import visitors.Evaluator;

import javax.swing.*;
import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Guitar Tab DSL");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1200, 800);

            // Left Side: Text Input
            JTextArea inputArea = new JTextArea();
            inputArea.setLineWrap(true);
            inputArea.setWrapStyleWord(true);

            // Load Data
            Path path = Paths.get("input.g");
            try {
                inputArea.setText(Files.readString(path));
            } catch (IOException e) {
                inputArea.setText(""); // fallback
            }

            JScrollPane inputScroll = new JScrollPane(inputArea);
            JButton submitButton = new JButton("Run DSL");

            // Right Side: Printed Results
            JTextArea fixedArea = new JTextArea(
                    "Tab output will appear here.\n" +
                            "This side is read-only."
            );
            fixedArea.setEditable(false);
            fixedArea.setLineWrap(true);
            fixedArea.setWrapStyleWord(true);
            fixedArea.setBackground(new Color(245, 245, 245));
            JScrollPane rightScroll = new JScrollPane(fixedArea);

            // Button: Run DSL method
            submitButton.addActionListener(e -> {
                String source = inputArea.getText().trim();
                if (source.isEmpty()) {
                    fixedArea.setText("No input provided.");
                    return;
                }

                try {
                    String result = runDSL(source);
                    fixedArea.setText(result);
                } catch (Exception ex) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Error while parsing/evaluating:\n")
                            .append(ex.getClass().getSimpleName())
                            .append(": ")
                            .append(ex.getMessage() == null ? "" : ex.getMessage())
                            .append("\n\n");

                    for (StackTraceElement ste : ex.getStackTrace()) {
                        sb.append(ste.toString()).append("\n");
                    }

                    fixedArea.setText(sb.toString());
                }
            });

            JPanel leftPanel = new JPanel(new BorderLayout());
            leftPanel.add(inputScroll, BorderLayout.CENTER);
            leftPanel.add(submitButton, BorderLayout.SOUTH);

            // SPLIT PANEL
            JSplitPane splitPane = new JSplitPane(
                    JSplitPane.HORIZONTAL_SPLIT,
                    leftPanel,
                    rightScroll
            );
            splitPane.setResizeWeight(0.5);
            splitPane.setDividerLocation(400);

            frame.setContentPane(splitPane);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    private static String runDSL(String source) throws Exception {
        GLangLexer lexer = new GLangLexer(CharStreams.fromString(source));

        lexer.reset();
        TokenStream tokens = new CommonTokenStream(lexer);
        System.out.println("Done tokenizing");

        GLangParser parser = new GLangParser(tokens);
        ParseTreeToAST visitor = new ParseTreeToAST();
        Node parsedProgram = parser.program().accept(visitor);
        System.out.println("Done parsing");

        ByteArrayOutputStream outputBytes = new ByteArrayOutputStream();
        PrintStream outputString = new PrintStream(outputBytes, true, StandardCharsets.UTF_8);

        Evaluator evaluator = new Evaluator();
        evaluator.setOutput(outputString);
        parsedProgram.accept(evaluator, null);
        System.out.println("Done evaluation");

        outputString.flush();
        return outputBytes.toString(StandardCharsets.UTF_8);
    }
}
