package vrize.community.moviereview.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserprofileRepository extends JpaRepository<Userprofile, UUID> {
}
