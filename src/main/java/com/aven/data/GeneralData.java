package com.aven.data;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GeneralData {

    public static final String PREFIX = "~";

    //Command Lists
    public static final List<String> TARKOV_COMMANDS = Arrays
            .asList("customs", "interchange", "shoreline", "reserve", "ammo");
    public static final List<String> TARKOV_COMMANDS_PREFIXED = addPrefixToCommands(TARKOV_COMMANDS);
    public static final List<String> FUN_COMMANDS = Arrays
            .asList("ping", "roll", "nekogirl");
    public static final List<String> FUN_COMMANDS_PREFIXED = addPrefixToCommands(FUN_COMMANDS);
    public static final List<String> OTHER_COMMANDS = Arrays
            .asList("info", "com/aven/commands", "clear", "github", "youtube", "soundcloud");
    public static final List<String> OTHER_COMMANDS_PREFIXED = addPrefixToCommands(OTHER_COMMANDS);

    //Design
    public static final int BLUE_COLOR_HEX = 0x71a2de;
    public static final int RED_COLOR_HEX = 0xff1100;

    //Maps Links
    private static final String MAG_GENIE_LINK = "https://mapgenie.io/tarkov/maps";
    public static final String INTERCHANGE_MAP = MAG_GENIE_LINK + "/interchange";
    public static final String SHORELINE_MAP = MAG_GENIE_LINK + "/shoreline";
    public static final String CUSTOMS_MAP = MAG_GENIE_LINK + "/customs";

    public static final String AMMO_CHART_V_12_9 =
            "https://docs.google.com/spreadsheets/d/1_l-gYeSt2MqIw62EdMZt_wefG0yO9L7dTaRM74c2J1w/htmlview";

    //Maps images
    private static final String IMAGES_PATH = "src/main/resources/pics.tarkov";
    public static final String INTERCHANGE_IMAGE = IMAGES_PATH + "/interchange.jpg";
    public static final String SHORELINE_IMAGE = IMAGES_PATH + "/shoreline.jpg";
    public static final String CUSTOMS_IMAGE = IMAGES_PATH + "/customs.jpg";
    public static final String RESERVE_IMAGE = IMAGES_PATH + "/reserve.jpg";

    //Other links
    public static final String GITHUB = "https://github.com/shumylo/AvenBot";
    public static final String YOUTUBE = "https://www.youtube.com/channel/UC9kgx_41P833y5aph2x2hUA";
    public static final String SOUNDCLOUD = "https://soundcloud.com/satellite-runner";
    public static final String NEKO_URL = "https://nekos.life/api/neko";

    public static final List<String> FAVOURITE_BANDS = Arrays.asList("Paper Kites", "Bon Iver", "Coldplay", "Radiohead");

    private static List<String> addPrefixToCommands(List<String> commands) {
        return commands.stream().map(s -> PREFIX + s).collect(Collectors.toList());
    }
}
