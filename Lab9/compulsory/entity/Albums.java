package entity;

import javax.persistence.*;

@Entity
@Table(name = "albums")
@NamedQueries(
        {
                @NamedQuery(name = "Albums.findByArtist", query = "SELECT x FROM Albums x WHERE x.artistId = :id"),
                @NamedQuery(name = "Albums.findByName", query = "SELECT x FROM Albums x WHERE x.name = :name")

        }
)
public class Albums {
    private int id;
    private String name;
    private int artistId;
    private Integer releaseYear;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "artist_id")
    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    @Basic
    @Column(name = "release_year")
    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Albums albums = (Albums) o;

        if (id != albums.id) return false;
        if (artistId != albums.artistId) return false;
        if (name != null ? !name.equals(albums.name) : albums.name != null) return false;
        if (releaseYear != null ? !releaseYear.equals(albums.releaseYear) : albums.releaseYear != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + artistId;
        result = 31 * result + (releaseYear != null ? releaseYear.hashCode() : 0);
        return result;
    }
}
