package fileup;

public class FileDTOInfo {
	private String fileName;
	private String fileReal;
	private int downloadCount;

	public int getDownloadCount() {
		return downloadCount;
	}

	public void setDownloadCount(int downloadCount) {
		this.downloadCount = downloadCount;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileReal() {
		return fileReal;
	}

	public void setFileReal(String fileReal) {
		this.fileReal = fileReal;
	}

	public FileDTOInfo(String fileName, String fileReal, int downloadCount) {
		super();
		this.fileName = fileName;
		this.fileReal = fileReal;
		this.downloadCount = downloadCount;
	}

}
