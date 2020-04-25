package com.timboektoe.fluts.io.input;

import java.util.List;
import java.util.Scanner;

public interface Reader {
    List<List<Integer>> readAllSchuurs(Scanner scanner, int numberSchuurs);
}
