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
            .asList("info", "commands", "clear", "github", "youtube", "soundcloud");
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
    public static final String INTERCHANGE = "https://external-preview.redd.it/y-JZHGz3yp4jJrjdKDlMKPuZsGvZEfoSj5tlZmKyh60.jpg?auto=webp&s=268fc16b72b4e2293c4386169d9856161d5b72b1";
    public static final String SHORELINE = "https://i.pinimg.com/originals/d8/e7/61/d8e761557db5c93b941b6eade14baf6e.jpg";
    public static final String CUSTOMS = "https://i.redd.it/8udfaht87zd51.png";
    public static final String RESERVE = "https://external-preview.redd.it/y_SQ2xkvGnLsiYYfrRJBLwUORKiEV33pgt9eV-8LRqk.jpg?auto=webp&s=b7ebed25bbd1e244aebf8c46d108afee73c9aea0";
    public static final String WOODS = "https://static.wikia.nocookie.net/escapefromtarkov_gamepedia/images/0/05/Glory4lyfeWoods_map_v4_marked.png/revision/latest?cb=20210103091918";

    //Other links
    public static final String GITHUB = "https://github.com/mylorii/AvenBot";
    public static final String YOUTUBE = "https://www.youtube.com/channel/UC9kgx_41P833y5aph2x2hUA";
    public static final String SOUNDCLOUD = "https://soundcloud.com/satellite-runner";
    public static final String NEKO_URL = "https://nekos.life/api/neko";

    public static final List<String> FAVOURITE_BANDS = Arrays.asList("Paper Kites", "Bon Iver", "Coldplay", "Radiohead");

    private static List<String> addPrefixToCommands(List<String> commands) {
        return commands.stream().map(s -> PREFIX + s).collect(Collectors.toList());
    }
}
