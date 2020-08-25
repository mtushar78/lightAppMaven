package commit.light.lightproject.repository;
import commit.light.lightproject.model.LightDBIdentity;
import commit.light.lightproject.model.LightInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LightInfoRepo extends JpaRepository<LightInfo, LightDBIdentity> {

    @Query(value = "select count(*) from light_info where db_no = :dbNo and light_no = :lightNo",
            nativeQuery = true)
    Integer ifLightInfoExists(int dbNo, int lightNo);
}
