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

    my ($id, $startX, $startY, $length, $width) = ($currString =~ m/(\d+)@(\d+),(\d+):(\d+)x(\d+)/);
    push @dataArray, clothData->new(id => $id, startX => $startX, startY => $startY, length => $length, width => $width);

}

foreach $data (@dataArray)
{
    print $data->id, " ", $data->startX, " ", $data->startY, " ", $data->length, " ", $data->width, "\n"
}
