<?php
// Routes

$app->group('/api/v1', function () use ($app) {
    
  // get all events
  $app->get('/events',function ($request, $response, $args) {
        $sth = $this->db->prepare("SELECT * FROM events e INNER JOIN organisators o ON e.organisator_id=o.id ORDER BY creationDate");
      $sth->execute();
      $todos = $sth->fetchAll();
      var_dump ($todos);
      return $this->response->withJson($todos);
  });

  $app->get('/events/[{id}]', function ($request, $response, $args) {
         $sth = $this->db->prepare("SELECT * FROM events e INNER JOIN organisators o ON e.organisator_id=o.id WHERE e.id=:id");
        $sth->bindParam("id", $args['id']);
        $sth->execute();
        $todos = $sth->fetchObject();
        return $this->response->withJson($todos);
    });

     // Add a new event
    $app->post('/events', function ($request, $response) {
        $event = json_decode($request->getBody());
        $sql = "INSERT INTO events (title, organisator_id, date, hour, adress, zipcode, city, comment, creationDate)"
                . "VALUES (:title :organisator_id :date :hour :adress :zipcode :city :comment :creationDate)";
        $sth = $this->db->prepare($sql);
        $sth->bindParam("title", $event->title);
        $sth->bindParam("organisator_id", $event->organisator_id);
        $sth->bindParam("date", $event->date);
        $sth->bindParam("hour", $event->hour);
        $sth->bindParam("adress", $event->adress);
        $sth->bindParam("zipcode", $event->zipcode);
        $sth->bindParam("city", $event->city);
        $sth->bindParam("comment", $event->comment);
        $sth->bindParam("creationDate", $event->creationDate);
        $sth->execute();
        $event->id = $this->db->lastInsertId();
        return $this->response->withJson($event)->withStatus(201);
    });

//    // DELETE a todo with given id
//    $app->delete('/events/[{id}]', function ($request, $response, $args) {
//        $sth = $this->db->prepare("DELETE FROM events WHERE id=:id");
//        $sth->bindParam("id", $args['id']);
//        $sth->execute();
//        return $this->response->withStatus(204); //no-content
//    });

// Update todo with given id
//    $app->put('/events/[{id}]', function ($request, $response, $args) {
//        $event = json_decode($request->getBody());
//        $sql = "UPDATE events SET task=:task,priority=:priority  WHERE id=:id";
//        $sth = $this->db->prepare($sql);
//        $sth->bindParam("id", $args['id']);
//        $sth->bindParam("task", $todo->task);
//        $sth->bindParam("priority", $todo->priority);
//        $sth->execute();
//        //load complete oci_fetch_object
//        $sth = $this->db->prepare("SELECT * FROM task WHERE id=:id");
//        $sth->bindParam("id", $args['id']);
//        $sth->execute();
//        $todo = $sth->fetchObject();
//        //$input['id'] = $args['id'];
//        return $this->response->withJson($todo);
//    });
});
