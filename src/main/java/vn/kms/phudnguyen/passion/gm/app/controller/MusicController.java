package vn.kms.phudnguyen.passion.gm.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/music")
public class MusicController {
  static String[] _0x77e0 = new String[]{"U", "W", "J", "H", "D", "G", "M", "A", "Y", "I", "X", "N", "R", "L", "B", "P", "K", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "c", "u", "f", "r", "length", "g", "replace"};
  static String[] _0x3f16x6 = new String[]{_0x77e0[0], _0x77e0[1], _0x77e0[2], _0x77e0[3], _0x77e0[4], _0x77e0[5], _0x77e0[6], _0x77e0[7], _0x77e0[8], _0x77e0[9], _0x77e0[10], _0x77e0[11], _0x77e0[12], _0x77e0[13], _0x77e0[14], _0x77e0[15], _0x77e0[16]};
  static String[] _0x3f16x7 = new String[]{_0x77e0[17], _0x77e0[18], _0x77e0[19], _0x77e0[20], _0x77e0[21], _0x77e0[22], _0x77e0[23], _0x77e0[24], _0x77e0[25], _0x77e0[26], _0x77e0[27], _0x77e0[28], _0x77e0[29], _0x77e0[30], _0x77e0[18], _0x77e0[18], _0x77e0[19]};

  public static String decodeDownloadUrl(String prefix, String _0x3f16x3, String suffix) {
    _0x3f16x3 = decode(_0x3f16x3);
    return prefix + _0x3f16x3 + suffix;
  }

  public static String decode(String input) {
    for (int i = 0; i < _0x3f16x6.length; i++) {
      input = input.replaceAll(_0x3f16x6[i], _0x3f16x7[i]);
    }
    return input;
  }
}
