#!/usr/bin/perl
use Class::Struct;

struct( clothData =>
        {
            id     => '$',
            startX => '$',
            startY => '$',
            length => '$',
            width  => '$'
        });

my $inFile = <$ARGV[0]>;
my $currString;
my @dataArray;

open FILE, $inFile or die "Invalid filename! Program will now exit.";

while(<FILE>)
{
    $currString = "$_";
    $currString =~ s/[' '#]//g;

    my ($id, $startX, $startY, $width, $length) = ($currString =~ m/(\d+)@(\d+),(\d+):(\d+)x(\d+)/);
    push @dataArray, clothData->new(id => $id, startX => $startX, startY => $startY, length => $length, width => $width);
    
}
close FILE;

foreach $data (@dataArray)
{
    my $currEndX = 0;
    my $currEndY = 0;
    my $currId = $data->id;
    my $currStartX = $data->startX;
    my $currStartY = $data->startY;

    $currEndX = $data->startX + $data->width;
    $currEndY = $data->startY + $data->length;

    foreach $compData (@dataArray)
    {
        if($currId != $compData->id)
        {
            if((($currStartX <= $compData->startX & $compData->startX <= $currEndX) 
                | ($compData->startX + $compData->width >= $currStartX & $compData->startX + $compData->width <= $currEndX)) & (($currStartY <= $compData->startY & $compData->startY <= $currEndY) 
                    |(($compData->startY+ $compData->length >= $currStartY) & $compData->startY + $compData->length <= $currEndY)))
            {
                print "here: ", $currStartX, " " , $currEndX, " ", $compData->startX, " ", $compData->startX + $compData->width, "\n";
                print "      ", $currStartY, " " , $currEndY, " ", $compData->startY, " ", $compData->startY + $compData->length, "\n";
            }
        }
    }


}
