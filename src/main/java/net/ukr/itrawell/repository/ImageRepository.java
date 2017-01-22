package net.ukr.itrawell.repository;

import java.util.Optional;

import net.ukr.itrawell.model.Image;

public interface ImageRepository extends GenericRepository<Image, Integer> {

    Optional<Image> findOne(Integer id);
}
