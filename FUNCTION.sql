CREATE FUNCTION produit_add_date() RETURNS trigger AS $produit_add_date$
    BEGIN
        -- Rappelons-nous qui a changé le salaire et quand
        NEW.dateajout := current_timestamp;
        RETURN NEW;
    END;
$produit_add_date$ LANGUAGE plpgsql;

CREATE TRIGGER produit_add_date BEFORE INSERT OR UPDATE ON produit
    FOR EACH ROW EXECUTE PROCEDURE produit_add_date();