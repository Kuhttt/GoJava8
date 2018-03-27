public class Food {

    long id;
    String name;
    Countries county;
    int expiration;

    public Food(String name, Countries county, int expiration) {
        this.id = idGenerator.getUId();
        this.name = name;
        this.county = county;
        this.expiration = expiration;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Countries getCounty() {
        return county;
    }

    public void setCounty(Countries county) {
        this.county = county;
    }

    public int getExpiration() {
        return expiration;
    }

    public void setExpiration(int expiration) {
        this.expiration = expiration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Food food = (Food) o;

        return id == food.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", county=" + county +
                ", expiration=" + expiration +
                '}';
    }
}
