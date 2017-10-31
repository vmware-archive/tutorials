package daleco.database;

public class DalecoItem {
    private Integer id;
    private String description;
    private String imageName;
    
    public Integer getId() {
    		return this.id;
    }
    public void setId(Integer id) {
    		this.id = id;
    }
    public String getDescription() {
    		return this.description;
    }
    public void setDescription(String description) {
    		this.description = description;
    }
    public String getImageName() {
    		return this.imageName;
    }
    public void setImageName(String imageName) {
    		this.imageName = imageName;
    }
    public String toString() {
    		return "id: " + this.id.toString() + "\n description: " + this.description + "\n" + "image name: " + this.imageName;
    }
}
