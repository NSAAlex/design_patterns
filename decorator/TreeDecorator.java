package decorator;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class TreeDecorator extends Tree {

    public TreeDecorator(ArrayList<String> lines) {
        super(lines);
    }

   
    static String stripAnsi(String s) {
        return s.replaceAll("\033\\[[0-9;]*m", "");
    }

    
    static String getLeadingColor(String s) {
        Matcher m = Pattern.compile("^(\033\\[[0-9;]*m)").matcher(s);
        return m.find() ? m.group(1) : "";
    }

    static String getRESET() {
        return "\033[0m";
    }

    
    protected void integrateDecor(ArrayList<String> decor) {
        for (int i = 0; i < lines.size() && i < decor.size(); i++) {
            String baseLine  = lines.get(i);
            String decorLine = decor.get(i);

            String decorColor  = getLeadingColor(decorLine);
            String decorVisual = stripAnsi(decorLine);

            
            if (decorVisual.trim().isEmpty()) {
                continue;
            }

            String baseVisual  = stripAnsi(baseLine);
            int    maxLen      = Math.max(baseVisual.length(), decorVisual.length());
            String[] baseColors = buildColorMap(baseLine);

            StringBuilder out          = new StringBuilder();
            String        currentColor = "";

            for (int j = 0; j < maxLen; j++) {
                char bc = (j < baseVisual.length())  ? baseVisual.charAt(j)  : ' ';
                char dc = (j < decorVisual.length()) ? decorVisual.charAt(j) : ' ';

                String targetColor;
                char   outChar;

                if (dc != ' ') {
                    outChar     = dc;
                    targetColor = decorColor;
                } else {
                    outChar     = bc;
                    targetColor = (j < baseColors.length) ? baseColors[j] : "";
                }

                if (!targetColor.equals(currentColor)) {
                    if (!currentColor.isEmpty()) out.append(getRESET());
                    if (!targetColor.isEmpty())  out.append(targetColor);
                    currentColor = targetColor;
                }
                out.append(outChar);
            }

            if (!currentColor.isEmpty()) out.append(getRESET());
            lines.set(i, out.toString());
        }
    }

    
    static String[] buildColorMap(String line) {
        String   visual = stripAnsi(line);
        String[] map    = new String[visual.length()];
        Arrays.fill(map, "");

        String activeColor = "";
        int vi = 0;   
        int ci = 0;   

        while (ci < line.length()) {
            if (line.charAt(ci) == '\033') {
                int end = line.indexOf('m', ci);
                if (end == -1) break;
                String seq = line.substring(ci, end + 1);
                activeColor = seq.equals(getRESET()) ? "" : seq;
                ci = end + 1;
            } else {
                if (vi < map.length) map[vi] = activeColor;
                vi++;
                ci++;
            }
        }
        return map;
    }
}