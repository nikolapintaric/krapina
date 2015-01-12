package THEGAME.manager;

import THEGAME.Section;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Mihael on 1/9/2015.
 */
public class ConfigManager {

    private HashMap<String, Section> sections;
    private String path;

    public ConfigManager(){
        sections = new HashMap<String, Section>();
    }

    private String cleanString(String s){
        return s.replaceAll("\\s","");
    }

    public Boolean parseFile(String file_name){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file_name));
            String line;
            String currentSection = "";
            while((line = reader.readLine()) != null){
                line = cleanString(line);
                if(line == "") continue;
                int off = 0;
                if(line.charAt(off) == '['){
                    off++;
                    String newSection = "";
                    while(line.charAt(off) != ']'){
                        newSection += line.charAt(off++);
                    }
                    newSection = cleanString(newSection);
                    currentSection = newSection;
                    sections.put(currentSection, new Section());
                    System.out.println("Detected section: " + currentSection);
                } else {
                    String newName = "", newValue = "";
                    while(line.charAt(off) != '='){
                        newName += line.charAt(off++);
                    }
                    off++;
                    newName = cleanString(newName);
                    while(off < line.length()){
                        newValue += line.charAt(off++);
                    }
                    newValue = cleanString(newValue);
                    sections.get(currentSection).addPair(newName, newValue);
                    System.out.println("Added new value-name pair: " + newName + " " + newValue + " to section " + currentSection);
                }

            }
        }
        catch (Exception ex){
            System.out.println("Exception " + ex.getMessage());
            return false;
        }
        return true;
    }

    public void writeToFile(String file_name){
        try {
            PrintWriter writer = new PrintWriter(file_name);
            for(Map.Entry<String, Section> entry : sections.entrySet()){
                String key = entry.getKey();
                HashMap<String, String> section  = entry.getValue().getValueMap();
                writer.write("[" + key + "]\r\n");
                for(Map.Entry<String, String> entry2 : section.entrySet()){
                    String key2 = entry2.getKey();
                    String value = entry2.getValue();
                    writer.write("\t" + key2 + " = " + value + "\r\n");
                }
            }
            writer.close();
        }
        catch (Exception ex){
            System.out.println("Exception " + ex.getMessage());
        }

    }

    public Boolean hasValue(String section_name, String key){
        return sections.get(section_name).hasValue(key);
    }

    public int getInt(String section_name, String key){
        return Integer.parseInt(sections.get(section_name).getValue(key));
    }

    public Boolean getBool(String section_name, String key){
        return Boolean.parseBoolean(sections.get(section_name).getValue(key));
    }

    public String getString(String section_name, String key){
        return sections.get(section_name).getValue(key);
    }

    public void addValueToSection(String section_name, String key, String value){
        sections.get(section_name).addPair(key, value);
    }

    public HashMap<String,String> getAccessToSectionData(String section_name){
        return sections.get(section_name).getValueMap();
    }

}
