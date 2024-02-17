package Helpers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;

public class Helper {

	private static final AtomicInteger screenshotCount = new AtomicInteger(1);

	public static void takeScreenshot(WebDriver driver, String fileName) {
		// Verifique se o WebDriver suporta captura de tela
		if (driver instanceof TakesScreenshot) {
			TakesScreenshot screenshotDriver = (TakesScreenshot) driver;

			// Capture a screenshot como um arquivo
			File screenshot = screenshotDriver.getScreenshotAs(OutputType.FILE);

			// Especifique o caminho base onde você deseja salvar os screenshots
			String baseScreenshotDirectory = "screenshots/";

			// Adicione a data atual e um identificador único ao nome do arquivo
			String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
			String uniqueIdentifier = String.format("%03d", screenshotCount.getAndIncrement());
			// Número sequencial com pelo menos 3 dígitos
			String updatedFileName = fileName + "_" + timestamp + "_" + uniqueIdentifier + ".png";

			// Obtenha o diretório atual (ano/mês)
			String currentYearMonth = new SimpleDateFormat("yyyyMM").format(new Date());
			Path screenshotDirectory = Paths.get(baseScreenshotDirectory, currentYearMonth);

			// Crie o diretório se não existir
			if (!Files.exists(screenshotDirectory)) {
				try {
					Files.createDirectories(screenshotDirectory);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			Path screenshotPath = screenshotDirectory.resolve(updatedFileName);

			try {
				// Mova o arquivo de screenshot para o diretório especificado
				Files.move(screenshot.toPath(), screenshotPath);
				//System.out.println("Screenshot salvo em: " + screenshotPath.toString());
			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
		} else {
			System.out.println("WebDriver não suporta captura de tela.");
		}
	}
	
	public static void deleteScreenshotsFolder() {
        String baseScreenshotDirectory = "screenshots/";

        try {
            // Crie o caminho do diretório
            Path screenshotsPath = Paths.get(baseScreenshotDirectory);

            // Exclua o diretório e seu conteúdo recursivamente
            Files.walkFileTree(screenshotsPath, EnumSet.noneOf(FileVisitOption.class), Integer.MAX_VALUE, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    Files.delete(file);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    // Lidar com falhas ao visitar arquivos, se necessário
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    if (exc == null) {
                        Files.delete(dir);
                        return FileVisitResult.CONTINUE;
                    } else {
                        // Lidar com falhas ao visitar diretórios, se necessário
                        return FileVisitResult.CONTINUE;
                    }
                }
            });

            System.out.println("Pasta de screenshots excluída com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
